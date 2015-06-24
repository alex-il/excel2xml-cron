package com.verint.api.xml.dl;

/**
 * Created by obranopolsky on 17/06/2015.
 */

public class XmlFileTemplate {

    public static final String REQ_WEBPLATFORM_TEMLATE = "<request>\n" +
            "    <authentication>\n" +
            "        <consumerIdentifier>%s</consumerIdentifier>\n" +
            "        <userIdentifier>%s</userIdentifier>\n" +
        	"        <requestId>%s</requestId>\n" + 
    		"        <requestTime>%s</requestTime>\n" +
            "    </authentication>\n" +
            "    <service>\n" +
            "        <method>%s</method>\n" +
            "        <action>%s</action>\n" +
            "    </service>\n" +
            "    <parameters>\n" +
            "        <WebPlatform id=\"%s\" />\n" +
            "    </parameters>\n" +
            "</request>\n";

                                                                                                                                                             
    public static final String CR_CREATE_TEMLATE = "<request>\n" +                                                                                                                                                         
            "    <authentication>\n" +                                                    //    "    <authentication>\n" +                                                                                                 
            "        <consumerIdentifier>%s</consumerIdentifier>\n" +  	  				  //    "        <consumerIdentifier>consumerIdentifier</consumerIdentifier>\n" +                                                  			
            "        <userIdentifier>%s</userIdentifier>\n" +                             //    "        <userIdentifier>userIdentifier</userIdentifier>\n" +
            "        <requestId>%s</requestId>\n" + 
    		"        <requestTime>%s</requestTime>\n" +
            "    </authentication>\n" +                                                   //    "    </authentication>\n" +                                                                                                

            "    <service>\n" +                                                           //    "    <service>\n" +                                                                                                        
            "        <method>%s</method>\n" +                                             //    "        <method>cr</method>\n" +                                                                                          
            "        <action>%s</action>\n" +                                         //    "        <action>create</action>\n" +                                                                                      
            "    </service>\n" +                                                          //    "    </service>\n" +                                                                                                       
            "    <parameters>\n" +                                                        //    "    <parameters>\n" +                                                                                                     
            "        <webPlatform id=\"%s\">\n" +                                          //    "        <webPlatform id=\"2\">\n" +                                                                                       
            "            <cr>\n" +                                                        //    "            <cr>\n" +                                                                                                     
            "                <configurationParameters>\n" +                               //    "                <configurationParameters>\n" +                                                                            
            "                    <id>%s</id>\n" +                                           //    "                    <id></id>\n" +                                                                                        
            "                    <name>%s</name>\n" +                          //    "                    <name>suspicius guy</name>\n" +                                                                       
            "                    <networkStrategy>%s</networkStrategy>\n" +               //    "                    <networkStrategy>ip</networkStrategy>\n" +                                                            
            "                    <priority>%s</priority>\n" +                        //    "                    <priority>regular</priority>\n" +                                                                     
            "                    <validFrom>%s</validFrom>\n" +         //    "                    <validFrom>2015-05-03T15:38:45Z</validFrom>\n" +                                                      
            "                    <validTo>%s</validTo>\n" +             //    "                    <validTo>2015-05-13T15:38:45Z</validTo>\n" +                                                          
            "                    <scheduleCron>%s</scheduleCron>\n" +              //    "                    <scheduleCron>5 8 * * 6</scheduleCron>\n" +                                                           
            "                    <periodicRange>%s</periodicRange>\n" +                 //    "                    <periodicRange>week</periodicRange>\n" +                                                              
            "                    <runImmediately>%s</runImmediately>\n" +                  //    "                    <runImmediately>0</runImmediately>\n" +                                                               
            "                    <virtualAgentPolicy>%s</virtualAgentPolicy>\n" +   //    "                    <virtualAgentPolicy>spesific</virtualAgentPolicy>\n" +                                                
            "                    <virtualAgent>%s</virtualAgent>\n" +    //    "                    <virtualAgent>stalker@outlook.com</virtualAgent>\n" +                                                 
            "                    <crStatus>%s</crStatus>\n" +                         //    "                    <crStatus>active</crStatus>\n" +                                                                      
            "                    <customerCrId>%s</customerCrId>\n" +                  //    "                    <customerCrId>T_123</customerCrId>\n" +                                                               
            "                    <deltaCrawling>%s</deltaCrawling>\n" +                    //    "                    <deltaCrawling>1</deltaCrawling>\n" +                                                                 
            "                    <proxyHostPort>%s</proxyHostPort>\n" +                     //    "                    <proxyHostPort></proxyHostPort>\n" +                                                                  
            "                    <proxyUserName>%s</proxyUserName>\n" +                     //    "                    <proxyUserName></proxyUserName>\n" +                                                                  
            "                    <proxyPassword>%s</proxyPassword>\n" +                     //    "                    <proxyPassword></proxyPassword>\n" +                                                                  
            "                </configurationParameters>\n" +                              //    "                </configurationParameters>\n" +                                                                           
            "                <tags>\n" +                                                  //    "                <tags>\n" +                                                                                               
            "                    <tag>%s</tag>\n" +                                      //    "                    <tag>man</tag>\n" +                                                                                   
            "                </tags>\n" +                                                 //    "                </tags>\n" +                                                                                              
            "                <countries>\n" +                                             //    "                <countries>\n" +                                                                                          
            "                    <county>%s</county>\n" +                                 //    "                    <county>US</county>\n" +                                                                              
            "                </countries>\n" +                                            //    "                </countries>\n" +                                                                                         
            "                <inputParameters>\n" +                                       //    "                <inputParameters>\n" +                                                                                    
            "                    <parameter>\n" +                                         //    "                    <parameter>\n" +                                                                                      
            "                        <name>monthsBack</name>\n" +                         //    "                        <name>monthsBack</name>\n" +                                                                      
            "                        <value>%s</value>\n" +                               //    "                        <value>3</value>\n" +                                                                             
            "                    </parameter>\n" +                                        //    "                    </parameter>\n" +                                                                                     
            "                    <parameter>\n" +                                         //    "                    <parameter>\n" +                                                                                      
            "                        <name>url</name>\n" +                                //    "                        <name>url</name>\n" +                                                                             
            "                        <value>%s</value>\n" + 							  //    "                        <value>http://facbook.com/suspiciousguy</value>\n" +                                              
            "                    </parameter>\n" +                                        //    "                    </parameter>\n" +                                                                                     
            "                    <parameter>\n" +                                         //    "                    <parameter>\n" +                                                                                      
            "                        <name>getAlbums</name>\n" +                          //    "                        <name>getAlbums</name>\n" +                                                                       
            "                        <value>%s</value>\n" +                               //    "                        <value>0</value>\n" +                                                                             
            "                    </parameter>\n" +                                        //    "                    </parameter>\n" +                                                                                     
            "                    <parameter>\n" +                                         //    "                    <parameter>\n" +                                                                                      
            "                        <name>getFriends</name>\n" +                         //    "                        <name>getFriends</name>\n" +                                                                      
            "                        <value>%s</value>\n" +                               //    "                        <value>1</value>\n" +                                                                             
            "                    </parameter>\n" +                                        //    "                    </parameter>\n" +                                                                                     
            "                </inputParameters>\n" +                                      //    "                </inputParameters>\n" +                                                                                   
            "            </cr>\n" +                                                       //    "            </cr>\n" +                                                                                                    
            "        </webPlatform>\n" +                                                  //    "        </webPlatform>\n" +                                                                                               
            "    </parameters>\n" +                                                       //    "    </parameters>\n" +                                                                                                    
            "</request>\n"                                                                //    "</request>\n"                                                                                                             
            ;



    public static final String VA_SELECT_DELETE_TEMLATE =  "<request>\n" +
            "\t<authentication>\n" +
            "\t\t<consumerIdentifier>%s</consumerIdentifier>\n" +
            "\t\t<userIdentifier>%s</userIdentifier>\n" +
            "\t\t<requestId>%s</requestId>\n" +
            "\t\t<requestTime>%s</requestTime>\n" +
            "\t</authentication>\n" +
            "\t<service>\n" +
            "\t\t<method>%s</method>\n" +
            "\t\t<action>%s</action>\n" +
            "\t</service>\n" +
            "\t<parameters>\n" +
            "\t\t<webPlatform id=\"%s\">\n" +
            "\t\t\t<va id=\"%s\"></va>\n" +
            "\t\t</webPlatform>\n" +
            "\t</parameters>\n" +
            "</request>\n" +
            "\n"
            ;


    public static final String VA_CREATE_TEMLATE = "<request>\n" +
    	      "\t<authentication>\n" +
    	      "\t\t<consumerIdentifier>%s</consumerIdentifier>\n" +
    	      "\t\t<userIdentifier>%s</userIdentifier>\n" +
    	      "\t\t<requestId>%s</requestId>\n" +
    	      "\t\t<requestTime>%s</requestTime>\n" +
    	      "\t</authentication>\n" +
    	      "\t<service>\n" +
    	      "\t\t<method>%s</method>\n" +
    	      "\t\t<action>%s</action>\n" +
    	      "\t</service>\n" +
    	      "\t<parameters>\n" +
    	      "\t\t<webPlatform id=\"%s\">\n" +
    	      "\t\t\t<va>\n" +
    	      "\t\t\t\t<parameters>\n" +
    	      "\t\t\t\t\t<id></id>\n" +
    	      "\t\t\t\t\t<userName>%s</userName>\n" +
    	      "\t\t\t\t\t<description>%s</description>\n" +
    	      "\t\t\t\t\t<url>%s</url>\n" +
    	      "\t\t\t\t\t<nickName>%s</nickName>\n" +
    	      "\t\t\t\t\t<profileId>%s</profileId>\n" +
    	      "\t\t\t\t\t<password>%s</password>\n" +
    	      "\t\t\t\t\t<virtualAgentsStatus>%s</virtualAgentsStatus>\n" +
    	      "\t\t\t\t\t<networkStrategy>%s</networkStrategy>\n" +
    	      "\t\t\t\t\t<locale>%s</locale>\n" +
    	      "\t\t\t\t\t<timeZone>%s</timeZone>\n" +
    	      "\t\t\t\t\t<userAgent>%s</userAgent>\n" +
    	      "\t\t\t\t\t<acceptLanguage>v</acceptLanguage>\n" +
    	      "\t\t\t\t\t<email>%s</email>\n" +
    	      "\t\t\t\t\t<emailPassword>%s</emailPassword>\n" +
    	      "\t\t\t\t\t<securityQuestion>%s</securityQuestion>\n" +
    	      "\t\t\t\t\t<securityAnswer>%s</securityAnswer>\n" +
    	      "\t\t\t\t\t<phoneNumber>%s</phoneNumber>\n" +
    	      "\t\t\t\t\t<proxyHostPort>%s</proxyHostPort>\n" +
    	      "\t\t\t\t\t<proxyUserName>%s</proxyUserName>\n" +
    	      "\t\t\t\t\t<proxyPassword>%s</proxyPassword>\n" +
    	      "\t\t\t\t\t<consumerVaId>%s</consumerVaId>\n" +
    	      "\t\t\t\t\t<OAuthCode>%s</OAuthCode>\n" +
    	      "\t\t\t\t\t<OAuthClientId>%s</OAuthClientId>\n" +
    	      "\t\t\t\t\t<OAuthClientSecret>%s</OAuthClientSecret>\n" +
    	      "\t\t\t\t</parameters>\n" +
    	      "\t\t\t\t<counries>\n" +
    	      "\t\t\t\t\t<county>%s</county>\n" +
    	      "\t\t\t\t</counries>\n" +
    	      "\t\t\t\t<tags>\n" +
    	      "\t\t\t\t\t<tag>%s</tag>\n" +
    	      "\t\t\t\t</tags>\n" +
    	      "\t\t\t</va>\n" +
    	      "\t\t</webPlatform>\n" +
    	      "\t</parameters>\n" +
    	      "</request>\n"
    	      ;




    

    
    
}
