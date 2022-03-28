package com.cocoa.bean.obj;

import com.cocoa.bean.cls.BeanInfo;

import java.util.List;

public class BuildingCompany extends ProfitOrganization implements BeanInfo<BuildingCompany> {

    private List<User> users;

    private String content;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
