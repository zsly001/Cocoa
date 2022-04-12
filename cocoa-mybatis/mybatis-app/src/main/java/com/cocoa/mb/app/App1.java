package com.cocoa.mb.app;

import com.cocoa.mb.app.mapper.ActivityProjectMapper;
import com.cocoa.mb.app.mapper.ActivityTagMapper;
import com.cocoa.mb.app.mapper.TmMapper;
import com.cocoa.mb.po.ActivityProject;
import com.cocoa.mb.po.ActivityTag;
import com.cocoa.mb.po.Tm;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

public class App1 {

    private static SqlSessionFactory sessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"pool");
    }


    public static void selectOne(){
        try(SqlSession session = sessionFactory.openSession()){
            ActivityTag tag = session.selectOne("com.cocoa.mb.app.mapper.ActivityTagMapper.oneTag", 1);
            System.out.println(tag);
            ActivityTagMapper mapper = session.getMapper(ActivityTagMapper.class);
            ActivityTag tag2 = mapper.oneTag(2);
            System.out.println(tag2);
        }
    }

    public static void insert(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityTag tag = new ActivityTag();
            tag.setName("xxx测试");
            tag.setStatus(0);
            session.insert("com.cocoa.mb.app.mapper.ActivityTagMapper.save",tag);
            //session.commit();
        }
    }

    public static void update(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityTagMapper mapper = session.getMapper(ActivityTagMapper.class);
            //int n = mapper.updateStatus(1, 0);
            int n = mapper.updateField("status", 0, 1);
            System.out.println(n);
        }
    }

    public static void selectList(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityTagMapper mapper = session.getMapper(ActivityTagMapper.class);
            List<ActivityTag> tags = mapper.getList("status", 0);
            System.out.println(tags);
        }
    }

    public static void selectCount(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityTagMapper mapper = session.getMapper(ActivityTagMapper.class);
            int count = mapper.count("status", 0);
            System.out.println(count);
        }
    }


    public static void tx(){
        try(SqlSession session = sessionFactory.openSession()){
            ActivityTagMapper mapper = session.getMapper(ActivityTagMapper.class);
            ActivityTag tag = new ActivityTag();
            tag.setName("xxx测试");
            tag.setStatus(0);
            mapper.save(tag);
            mapper.updateStatus(58,0);
            int n=0;
            System.out.println(1/n);
            session.commit();
        }
    }

    public static void dyc1(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityProjectMapper mapper = session.getMapper(ActivityProjectMapper.class);
            Map<String,Object> param = new LinkedHashMap<>();
            param.put("activity_name","%测试%");
            List<ActivityProject> projects = mapper.getList(param);
            Optional.ofNullable(projects).orElseGet(ArrayList::new).stream().forEach(System.out::println);
        }
    }

    public static void dyc2(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityProjectMapper mapper = session.getMapper(ActivityProjectMapper.class);
            ActivityProject project = new ActivityProject();
            project.setActivityId(6L);
            project.setActivityName("dfdfdf");
            project.setStatus(20);
            int n = mapper.update(project);
            System.out.println(n);
        }
    }

    public static void dyc3(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityProjectMapper mapper = session.getMapper(ActivityProjectMapper.class);
            List<Integer> status = Arrays.asList(1,2,3);
            List<ActivityProject> projects = mapper.selectByStatus(status);
            Optional.ofNullable(projects).orElseGet(ArrayList::new).stream().forEach(System.out::println);
        }
    }

    public static void dyc5(){
        try(SqlSession session = sessionFactory.openSession(true)){
            ActivityProjectMapper mapper = session.getMapper(ActivityProjectMapper.class);
            List<ActivityProject> status = new ArrayList<>();
            ActivityProject p1 = new ActivityProject();
            p1.setStatus(1);
            ActivityProject p2 = new ActivityProject();
            p2.setStatus(2);
            List<ActivityProject> projects = mapper.selectList(Arrays.asList(p1,p2));
            Optional.ofNullable(projects).orElseGet(ArrayList::new).stream().forEach(System.out::println);
        }
    }


    public static void tm1(){
        try(SqlSession session = sessionFactory.openSession(true)){
            long start = System.nanoTime();
            TmMapper mapper = session.getMapper(TmMapper.class);
            Tm t1 = mapper.get(1);
            System.out.println(t1);
            long end = System.nanoTime();
            long nano = end-start;
            System.out.println(nano);
            Timestamp tmp = new Timestamp(nano);
            System.out.println(tmp);
            /*Tm tm = new Tm();
            tm.setStartTime(new java.util.Date());
            tm.setEndTime(new Timestamp(System.nanoTime()));
            tm.setCreateAt(new Date(System.currentTimeMillis()));
            int n = mapper.save(tm);
            System.out.println(n);*/
        }
    }

    public static void main(String[] args) throws Exception{


        //selectOne();
        //insert();
        //update();
        //selectList();
        //selectCount();
        //tx();
        //dyc1();
        //dyc2();
        //dyc3();
        //dyc5();
        tm1();

    }

}
