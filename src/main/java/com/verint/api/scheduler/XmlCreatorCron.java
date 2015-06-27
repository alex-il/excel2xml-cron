package com.verint.api.scheduler;


import static com.verint.api.ui.XmlCreatorUI.print;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory;

import com.verint.api.common.ApiProperties;
import com.verint.api.excel.converter.ExcelReader;
import com.verint.api.excel.converter.pojo.ExcelWorkbook;
import com.verint.api.excel.converter.pojo.ExcelWorksheet;

public class XmlCreatorCron implements Runnable, Constant, ApiProperties {
	
	private static int c = 1;
	private String absoluteFile;
	private String outputFolder;

	public XmlCreatorCron(String absoluteFile) {

	}

	public XmlCreatorCron(String absoluteFile, String outputFolder) {
		this.absoluteFile = absoluteFile;
		this.outputFolder = outputFolder;
	}

	public XmlCreatorCron() {
		// TODO Auto-generated constructor stub
	}

	public void run() {

		try {
			ExcelWorkbook book = new ExcelReader().convert(absoluteFile);
			final ArrayList<ExcelWorksheet> sheets = (ArrayList<ExcelWorksheet>) book.getSheets();
			for (ExcelWorksheet s : sheets) {
				final String sName = s.getName();
				print(" Creating job for sheet: "+sName);
				final Hashtable<String, ArrayList<String>> data = s.getData();
				final int maxCols = s.getMaxCols()-1;
				if(maxCols<1){
					return;
				}
				
				for (int index = 0; index < maxCols; index++) {

					SchedulerFactory sf = new StdSchedulerFactory();
					Scheduler sched = sf.getScheduler();
					final String currentJobName = JOB_NAME +index+"_"+ c++;
					JobDetail job = newJob(XmlCreatorJob.class).withIdentity(currentJobName, currentJobName).build();
					final ArrayList<String> colList = data.get("cron");

					String cronExpression = "0/10 * * * * ?";
//					final Integer index = 0;
					final String cron = colList.get(index);
					if (cron != null && cron.length() > 10) {
						cronExpression = cron;
					}

					CronTrigger trigger = newTrigger().withIdentity(currentJobName, currentJobName)
							.withSchedule(cronSchedule(cronExpression)).build();
					final JobDataMap jobDataMap = job.getJobDataMap();
					jobDataMap.put(S_NAME, sName);
					jobDataMap.put(JP_ABS_PATH, outputFolder);
					jobDataMap.put(JOB_INDEX, index);
					jobDataMap.put(JOB_PARAMS, data);
					Date ft = sched.scheduleJob(job, trigger);
					sched.start();
					print(ft.toString());
					// sched.shutdown(true);
					SchedulerMetaData metaData = sched.getMetaData();
					System.err.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {

		XmlCreatorCron example = new XmlCreatorCron();
		example.run();
	}

}
