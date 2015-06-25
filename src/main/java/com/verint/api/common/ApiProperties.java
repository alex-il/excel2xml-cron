package com.verint.api.common;

public interface ApiProperties {
	public static final String JOB_PARAMS = "JOB_PARAMS";
	public static final String JOB_INDEX = "JOB_INDEX";
	public static final String S_NAME = "SHEET_NAME";
	public static final String JP_ABS_PATH = "JP_ABS_PATH";
	
	public static final String TAB_CR_CREATE = "CR-create";
	public static final String TAB_VA_SELECT_DELETE = "VA-Select-Delete";
	public static final String TAB_WEBPLATFORMS = "WebPlatforms_select";
	public static final String TAB_VA_CREATE = "VA-Create";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
//	public static final String  = "";
	
	public static final String CONSUMERIDENTIFIER = "consumerIdentifier";
	public static final String USER_ID = "userIdentifier";
	public static final String METHOD = "method";
	public static final String ACTION = "action";
	public static final String WEBPLATFORM_ID = "webPlatformId";
	public static final String ID = "id";
	public static final String NAME = "name";
//	public static final String CRAWLERSTRATEGY = "crawlerStrategy";
	public static final String NETWORKSTRATEGY = "networkStrategy";
	public static final String PRIORITY = "priority";
	public static final String VALIDFROM = "validFrom";
	public static final String VALIDTO = "validTo";
	public static final String SCHEDULECRON = "scheduleCron";
	public static final String PERIODICRANGE = "periodicRange";
	public static final String RUN_IMMEDIATELY = "runImmediately";
	public static final String VIRTUAL_AGENT_POLICY = "virtualAgentPolicy";
	public static final String VIRTUALAGENT = "virtualAgent";
	public static final String CR_STATUS = "crStatus";
	public static final String CUSTOMER_CR_ID = "customerCrId";
	public static final String DELTACRAWLING = "deltaCrawling";
	public static final String PROXYHOSTPORT = "proxyHostPort";
	public static final String PROXYUSERNAME = "proxyUserName";
	public static final String PROXYPASSWORD = "proxyPassword";
	public static final String TAGS = "tags";
	public static final String COUNTRIES = "countries";
	public static final String MONTHSBACK = "monthsBack";
	public static final String URL = "url";
	public static final String GETALBUMS = "getAlbums";
	public static final String GETFRIENDS = "getFriends";
	public static final String REQUEST_ID = "requestId";
	public static final String REQUEST_TIME = "requestTime";
	public static final String TYPE = "type";
	public static final String VA_ID = "vaId";
	public static final String CRON = "cron";
//	public static final String  = "";
//	public static final String  = "";


//	VA-edit
	public static final String VAC_id                  = "id";       
	public static final String VAC_userName            = "userName";       
	public static final String VAC_description         = "description";       
	public static final String VAC_url                 = "url";               
	public static final String VAC_nickName            = "nickName";          
	public static final String VAC_profileId           = "profileId";         
	public static final String VAC_password   		   = "password";   		
	public static final String VAC_virtualAgentsStatus = "virtualAgentsStatus";
	public static final String VAC_networkStrategy     = "networkStrategy";   
	public static final String VAC_locale              = "locale";            
	public static final String VAC_timeZone            = "timeZone";          
	public static final String VAC_userAgent           = "userAgent";         
	public static final String VAC_acceptLanguage      = "acceptLanguage";    
	public static final String VAC_email               = "email";             
	public static final String VAC_emailPassword       = "emailPassword";     
	public static final String VAC_securityQuestion    = "securityQuestion";  
	public static final String VAC_securityAnswer      = "securityAnswer";    
	public static final String VAC_phoneNumber         = "phoneNumber";       
	public static final String VAC_proxyHostPort       = "proxyHostPort";     
	public static final String VAC_proxyUserName       = "proxyUserName";     
	public static final String VAC_proxyPassword       = "proxyPassword";     
	public static final String VAC_consumerVaId  	   = "consumerVaId";  	
	public static final String VAC_OAuthCode     	   = "OAuthCode";     	
	public static final String VAC_OAuthClientId       = "OAuthClientId";     
	public static final String VAC_OAuthClientSecret   = "OAuthClientSecret"; 
	public static final String VAC_county    		   = "county";    		
	public static final String VAC_tag     			   = "tag";   
	
//	 CR create
	public static final String CR_id = "id";       
	public static final String CR_name = "name";               
	public static final String CR_networkStrategy = "networkStrategy";          
	public static final String CR_priority = "priority";         
	public static final String CR_validFrom = "validFrom";   		
	public static final String CR_validTo = "validTo";
	public static final String CR_scheduleCron = "scheduleCron";   
	public static final String CR_periodicRange = "periodicRange";            
	public static final String CR_runImmediately = "runImmediately";          
	public static final String CR_virtualAgentPolicy = "virtualAgentPolicy";         
	public static final String CR_virtualAgent = "virtualAgent";    
	public static final String CR_crStatus = "crStatus";             
	public static final String CR_customerCrId = "customerCrId";     
	public static final String CR_deltaCrawling = "deltaCrawling";  
	public static final String CR_proxyHostPort = "proxyHostPort";    
	public static final String CR_proxyUserName = "proxyUserName";       
	public static final String CR_proxyPassword = "proxyPassword";     
	public static final String CR_tags = "tags";     
	public static final String CR_countries = "countries";     
	public static final String CR_monthsBack = "monthsBack";  	
	public static final String CR_url = "url";     	
	public static final String CR_getAlbums = "getAlbums";     
	public static final String CR_getFriends = "getFriends"; 

	
	public static String ABSOLUTE_OUT_PATH = "c:/api-xml";
	public static String TEMPL_FILE = ABSOLUTE_OUT_PATH +"/%s_%s_%s.xml";
	public static String TEMPL_FILE_UI = "%s/%s_%s_%s.xml";
	public static String DELIMITER = "##";

}
