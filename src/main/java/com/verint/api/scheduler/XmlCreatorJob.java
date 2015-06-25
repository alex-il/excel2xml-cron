package com.verint.api.scheduler;

import static com.verint.api.common.ApiProperties.*;
import static com.verint.api.common.Util.getTimeStamp;
import static com.verint.api.scheduler.Constant.*;
import static com.verint.api.ui.XmlCreatorUI.print;
import static com.verint.api.xml.dl.XmlFileTemplate.*;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class XmlCreatorJob implements Job {

	private static int i = 0;

	public XmlCreatorJob() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// This job simply prints out its job name and the
		// date and time that it is running
		JobKey jobKey = context.getJobDetail().getKey();
		JobDataMap jdm = context.getJobDetail().getJobDataMap();
		i++;
		final String sheetName = jdm.getString(S_NAME);
		final String absPath = jdm.getString(JP_ABS_PATH);
		final Integer index = jdm.getIntValue(JOB_INDEX);
		final Hashtable<?, ?> sData = (Hashtable<?, ?>) jdm.get(JOB_PARAMS);

		if (sheetName == null || sheetName.length() < 4) {
			print("bad sheet name");
			return;
		}

		print(i + ":---->>>> execute Job for sheet: " + sheetName + "\n");
		String outStr = "";
		final String requestId = getRequestId();
		final Object consId = ((ArrayList<?>) sData.get(CONSUMERIDENTIFIER)).get(index);
		final Object uid = ((ArrayList<?>) sData.get(USER_ID)).get(index);
		final String rTime = getTimeStamp();
		final Object action = ((ArrayList<?>) sData.get(ACTION)).get(index);
		final Object method = ((ArrayList<?>) sData.get(METHOD)).get(index);
		final Object wid = ((ArrayList<?>) sData.get(WEBPLATFORM_ID)).get(index);

		if (TAB_CR_CREATE.equals(sheetName)) {
			final Object id			 			= ((ArrayList<?>) sData.get(CR_id					)).get(index);
			final Object name 					= ((ArrayList<?>) sData.get(CR_name					)).get(index);
			final Object networkStrategy 		= ((ArrayList<?>) sData.get(CR_networkStrategy 		)).get(index);
			final Object priority 				= ((ArrayList<?>) sData.get(CR_priority 			)).get(index);
			final Object validFrom 				= ((ArrayList<?>) sData.get(CR_validFrom 			)).get(index);
			final Object validTo 				= ((ArrayList<?>) sData.get(CR_validTo 				)).get(index);
			final Object scheduleCron 			= ((ArrayList<?>) sData.get(CR_scheduleCron 		)).get(index);
			final Object periodicRange 			= ((ArrayList<?>) sData.get(CR_periodicRange 		)).get(index);
			final Object runImmediately 		= ((ArrayList<?>) sData.get(CR_runImmediately 		)).get(index);
			final Object virtualAgentPolicy 	= ((ArrayList<?>) sData.get(CR_virtualAgentPolicy 	)).get(index);
			final Object virtualAgent 			= ((ArrayList<?>) sData.get(CR_virtualAgent 		)).get(index);
			final Object crStatus 				= ((ArrayList<?>) sData.get(CR_crStatus 			)).get(index);
			final Object customerCrId 			= ((ArrayList<?>) sData.get(CR_customerCrId 		)).get(index);
			final Object deltaCrawling 			= ((ArrayList<?>) sData.get(CR_deltaCrawling 		)).get(index);
			final Object proxyHostPort 			= ((ArrayList<?>) sData.get(CR_proxyHostPort 		)).get(index);
			final Object proxyUserName 			= ((ArrayList<?>) sData.get(CR_proxyUserName 		)).get(index);
			final Object proxyPassword 			= ((ArrayList<?>) sData.get(CR_proxyPassword 		)).get(index);
			final Object tags 					= ((ArrayList<?>) sData.get(CR_tags 				)).get(index);
			final Object countries 				= ((ArrayList<?>) sData.get(CR_countries 			)).get(index);
			final Object monthsBack 			= ((ArrayList<?>) sData.get(CR_monthsBack 			)).get(index);
			final Object url 					= ((ArrayList<?>) sData.get(CR_url 					)).get(index);
			final Object getAlbums 				= ((ArrayList<?>) sData.get(CR_getAlbums 			)).get(index);
			final Object getFriends			 	= ((ArrayList<?>) sData.get(CR_getFriends			)).get(index);

			outStr = String.format(CR_CREATE_TEMLATE, consId, uid, requestId, rTime, method, action
					, id				
					, name					
					, networkStrategy 		
					, priority 			
					, validFrom 			
					, validTo 				
					, scheduleCron 		
					, periodicRange 		
					, runImmediately 		
					, virtualAgentPolicy 	
					, virtualAgent 		
					, crStatus 			
					, customerCrId 		
					, deltaCrawling 		
					, proxyHostPort 		
					, proxyUserName 		
					, proxyPassword 		
					, tags 				
					, countries 			
					, monthsBack 			
					, url 					
					, getAlbums 			
					, getFriends			
					);
					

		} else if (TAB_VA_CREATE.equals(sheetName)) {
//XXX Ok!
			final Object id     			 = ((ArrayList<?>) sData.get(VAC_id)).get(index);
			final Object userName 			 = ((ArrayList<?>) sData.get(VAC_userName)).get(index);
			final Object url 				 = ((ArrayList<?>) sData.get(VAC_url)).get(index);
			final Object profileId 			 = ((ArrayList<?>) sData.get(VAC_profileId)).get(index);
			final Object password 			 = ((ArrayList<?>) sData.get(VAC_password)).get(index);
			final Object virtualAgentsStatus = ((ArrayList<?>) sData.get(VAC_virtualAgentsStatus)).get(index);
			final Object networkStrategy 	 = ((ArrayList<?>) sData.get(VAC_networkStrategy)).get(index);
			final Object locale              = ((ArrayList<?>) sData.get(VAC_locale           )).get(index);
			final Object timeZone            = ((ArrayList<?>) sData.get(VAC_timeZone         )).get(index);
			final Object userAgent           = ((ArrayList<?>) sData.get(VAC_userAgent        )).get(index);
			final Object acceptLanguage      = ((ArrayList<?>) sData.get(VAC_acceptLanguage   )).get(index);
			final Object email               = ((ArrayList<?>) sData.get(VAC_email            )).get(index);
			final Object emailPassword       = ((ArrayList<?>) sData.get(VAC_emailPassword    )).get(index);
			final Object securityQuestion    = ((ArrayList<?>) sData.get(VAC_securityQuestion )).get(index);
			final Object securityAnswer      = ((ArrayList<?>) sData.get(VAC_securityAnswer   )).get(index);
			final Object phoneNumber         = ((ArrayList<?>) sData.get(VAC_phoneNumber      )).get(index);
			final Object proxyHostPort       = ((ArrayList<?>) sData.get(VAC_proxyHostPort    )).get(index);
			final Object proxyUserName       = ((ArrayList<?>) sData.get(VAC_proxyUserName    )).get(index);
			final Object proxyPassword       = ((ArrayList<?>) sData.get(VAC_proxyPassword    )).get(index);
			final Object consumerVaId  	     = ((ArrayList<?>) sData.get(VAC_consumerVaId  	  )).get(index);
			final Object OAuthCode     	     = ((ArrayList<?>) sData.get(VAC_OAuthCode     	  )).get(index);
			final Object OAuthClientId       = ((ArrayList<?>) sData.get(VAC_OAuthClientId    )).get(index);
			final Object OAuthClientSecret   = ((ArrayList<?>) sData.get(VAC_OAuthClientSecret)).get(index);
			
			final Object countries    		     = ((ArrayList<?>) sData.get(VAC_county    		  )).get(index);
			final String country = createCountry(countries);
			
			final Object tags    	         = ((ArrayList<?>) sData.get(VAC_tag     	      )).get(index);
			final String tag = createTag(tags);
			
			
			outStr = String.format(VA_CREATE_TEMLATE, consId, uid, requestId, rTime, method, action, wid
					  , id					
					  , userName				
					  , url					
					  , profileId				
					  , password				
					  , virtualAgentsStatus 
					  , networkStrategy		
					  , locale          		
					  , timeZone        		
					  , userAgent        		
					  , acceptLanguage   		
					  , email            		
					  , emailPassword  	  
					  , securityQuestion  	
					  , securityAnswer    	
					  , phoneNumber       	
					  , proxyHostPort    		
					  , proxyUserName    		
					  , proxyPassword     	
					  , consumerVaId    		
					  , OAuthCode       		
					  , OAuthClientId     	
					  , OAuthClientSecret  
					  , country    		  
					  , tag     			  
					);
			
					
		} else if (TAB_VA_SELECT_DELETE.equals(sheetName)) {
			final Object vaId = ((ArrayList<?>) sData.get(VA_ID)).get(index);
			outStr = String.format(VA_SELECT_DELETE_TEMLATE, consId, uid, requestId, rTime, method, action, wid, vaId);

		} else if (TAB_WEBPLATFORMS.equals(sheetName)) {
			outStr = String.format(REQ_WEBPLATFORM_TEMLATE, consId, uid, requestId, rTime, action, method, wid);
			// System.err.println(TAB_WEBPLATFORMS);
		}

		String absoluteFilePath = createAbsoluteFilePath(sheetName, requestId, absPath);
		RandomAccessFile outFile;
		print("writing to file: " + absoluteFilePath);
		try {
			outFile = new RandomAccessFile(absoluteFilePath, "rw");
			outFile.writeBytes(outStr);
			outFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			print(" ==>> ERROR: " + e.getLocalizedMessage());
		}
		print(i + ":---->>>> executor SimpleJob says: " + jobKey + " executing at " + new Date() + "\n");
	}

	private String createTag(Object o) {
		return parse(o, "\t\t\t\t\t<tag>%s</tag>\n");
	}
	
	private String createCountry(Object o) {
		return parse(o, "\t\t\t\t\t<country>%s</country>\n");
	}
	
	private String parse(Object o, String template) {
		if (o == null)
			return "";
		String tags = (String) o;
		final String[] t = tags.split(DELIMITER);
		StringBuffer sb = new StringBuffer();
		for (String s : t) {
			sb.append(String.format(template, s));
		}
		return sb.toString();
	}

	private String getRequestId() {
		return REQ_ID_PREFIX + i;
	}

	private String createAbsoluteFilePath(String sheetName, String requestId, String absPath) {
		return String.format(TEMPL_FILE_UI, absPath, sheetName, getTimeStamp(), requestId);
//		if (absPath != null && absPath.length() > 3) {
//		}
//		return String.format(TEMPL_FILE, sheetName, getTimeStamp(), requestId);
	}

	public static void main(String[] args) {

//		String outStr = String.format(REQ_WEBPLATFORM_TEMLATE, "1", "2", "3", "4", "5", "6", "7");
//		outStr = String.format(VA_SELECT_DELETE_TEMLATE, "1", "2", "3", "4", "111", "112", "113", "114");
//		System.out.println(outStr);
		
		
	}
}
