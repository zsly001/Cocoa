package com.cocoa.util;

import com.cocoa.bean.obj.Company;
import com.cocoa.bean.obj.Organization;
import com.cocoa.bean.obj.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptTest {

    @Test
    public void map1(){
        User user = new User();
        user.setId(100);
        //user.setName("jack");
        user.setAge(20);
        user.setGender(1);
        user.setPhone("xiaomi");
        Organization o = new Organization();
        o.setId(1);
        o.setName("组织");
        user.setOrganization(o);
        user.setCompanies(Arrays.asList(new Company(1,"baidu"),new Company(2,"jd"),null));
        user.setCompanies(Arrays.asList(new Company(1,"baidu"),new Company(2,"jd"),null));

        User u1 = null;

        String name = Optional.ofNullable(user).map(User::getName).orElse("xxx");
        System.out.println(name);
        String name1 = Optional.ofNullable(user).map(user1 -> user1.getName()).orElse("xxx");
        System.out.println(name1);

        String name2 = Optional.ofNullable(user).flatMap(u -> u.getOrganization()).map(Organization::getName).orElse("oxx");
        System.out.println(name2);

        List<Company> companies = Optional.ofNullable(u1).map(User::getCompanies).orElse(new ArrayList<>());
        System.out.println(companies);

        List<String> compayNames = Optional.ofNullable(user)
                .map(User::getCompanies).orElse(new ArrayList<>())
                .stream().filter(Objects::nonNull).
                        filter(e->e.getId()<20).map(Company::getName).collect(Collectors.toList());
        System.out.println(compayNames);


    }


}
