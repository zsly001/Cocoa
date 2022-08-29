package com.cocoa;

import com.cocoa.bean.Util;
import com.cocoa.bean.obj.BuildingCompany;
import com.cocoa.bean.obj.User;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bena {

    private BuildingCompany company;

    @Before
    public void buildCompany(){
        User u1 = new User(1,"张三",23,1,"157278737677");
        User u2 = new User(2,"王五",29,1,"131627837652");
        company = new BuildingCompany();
        company.setId(1);
        company.setName("xxx建筑有限公司");
        company.setProfitType("工程建设费");
        company.setUsers(Arrays.asList(u1,u2));
    }


    @Test
    public void testFeilds(){
        List<Field> fields = Util.getAllDeclaredFields(BuildingCompany.class);
        fields.stream().forEach(System.out::println);


    }

    @Test
    public void testBeanInfo(){
        company.setUsers(new ArrayList<>());
        String info = company.info();
        System.out.println(info);
    }


}
