package com.hzy.girl.model;

import java.sql.Timestamp;

public class BaseModel {

    private String id;

    private String initiator;

    private String target;

    private long expired;

    private Timestamp dateTime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getInitiator() {
        return initiator;
    }
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    public Timestamp getDateTime() {
        return dateTime;
    }
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
    public long getExpired() {
        return expired;
    }
    public void setExpired(long expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id='" + id + '\'' +
                ", initiator='" + initiator + '\'' +
                ", target='" + target + '\'' +
                ", expired=" + expired +
                ", dateTime=" + dateTime +
                '}';
    }
}
