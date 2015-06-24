package com.verint.api.scheduler;


import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.util.StringUtil;
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
import static  com.verint.api.ui.XmlCreatorUI.*;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class XmlCreatorCron implements Runnable, Constants, ApiProperties {
	
	private static int c = 1;
	private String absoluteFile;

	public XmlCreatorCron() {

	}

	public XmlCreatorCron(String absoluteFile) {
		this.absoluteFile = absoluteFile;
	}

	public void run() {

		try {
			ExcelWorkbook book = new ExcelReader().convert(absoluteFile);
			final ArrayList<ExcelWorksheet> sheets = (ArrayList<ExcelWorksheet>) book.getSheets();
			for (ExcelWorksheet s : sheets) {
				final String sName = s.getName();
				print(" Creating job for sheet: "+sName);
				final Hashtable<String, ArrayList<String>> data = s.getData();
				final int maxCols = s.getMaxCols();
				if(maxCols<2){
					return;
				}
				
				SchedulerFactory sf = new StdSchedulerFactory();
				Scheduler sched = sf.getScheduler();
				final String currentJobName = JOB_NAME + c++;
				JobDetail job = newJob(XmlCreatorJob.class).withIdentity(currentJobName, currentJobName).build();
				final ArrayList<String> colList = data.get("cron");
				
				String cronExpression = "0/10 * * * * ?";
				final Integer index = 0;
				final String cron = colList.get(index);
				if( cron != null && cron.length()>10){
					cronExpression=cron;
				}
				
				CronTrigger trigger = newTrigger().withIdentity(currentJobName, currentJobName)
						.withSchedule(cronSchedule(cronExpression)).build();
				final JobDataMap jobDataMap = job.getJobDataMap();
				jobDataMap.put(S_NAME, sName);
				jobDataMap.put(JOB_INDEX, index);
				jobDataMap.put(JOB_PARAMS, data);
				Date ft = sched.scheduleJob(job, trigger);
				sched.start();

				// System.err.println("------- Waiting ... ------------");
				// sched.shutdown(true);
				SchedulerMetaData metaData = sched.getMetaData();
				System.err.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
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
