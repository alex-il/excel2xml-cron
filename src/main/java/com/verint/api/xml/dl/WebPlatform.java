package com.verint.api.xml.dl;
/**
 * Created by obranopolsky on 17/06/2015.
 */
public class WebPlatform {
    public String getConsumerIdentifier() {
        return consumerIdentifier;
    }

    public void setConsumerIdentifier(String consumerIdentifier) {
        this.consumerIdentifier = consumerIdentifier;
    }

    private String consumerIdentifier;

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getWebPlatforms() {
        return WebPlatforms;
    }

    public void setWebPlatforms(String webPlatforms) {
        WebPlatforms = webPlatforms;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    private String userIdentifier;
    private String WebPlatforms;
    private String select;
    private String id;
    private long time;
}
