package com.cocoa.mb.app.po;

import java.sql.Date;
import java.sql.Timestamp;

public class ActivityProject {

    private Long activityId;

    private String activityName;

    private Integer status;

    private String activityUid;

    private String activityUidName;

    private String creatorUid;

    private String creatorName;

    private String editorUid;

    private String editorName;

    private Integer isDeleted;

    private Timestamp createTime;

    private Timestamp updateTime;


    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActivityUid() {
        return activityUid;
    }

    public void setActivityUid(String activityUid) {
        this.activityUid = activityUid;
    }

    public String getActivityUidName() {
        return activityUidName;
    }

    public void setActivityUidName(String activityUidName) {
        this.activityUidName = activityUidName;
    }

    public String getCreatorUid() {
        return creatorUid;
    }

    public void setCreatorUid(String creatorUid) {
        this.creatorUid = creatorUid;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getEditorUid() {
        return editorUid;
    }

    public void setEditorUid(String editorUid) {
        this.editorUid = editorUid;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ActivityProject{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", status=" + status +
                ", activityUid='" + activityUid + '\'' +
                ", activityUidName='" + activityUidName + '\'' +
                ", creatorUid='" + creatorUid + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", editorUid='" + editorUid + '\'' +
                ", editorName='" + editorName + '\'' +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
