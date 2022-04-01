package com.cocoa.mb.app.po;

public class ActivityTag {

    private Integer id;

    private Integer status;

    private String name;

    @Override
    public String toString() {
        return "ActivityTag{" +
                "id=" + id +
                ", status=" + status +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
