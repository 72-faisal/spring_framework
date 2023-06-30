package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext con= new ClassPathXmlApplicationContext("com/spring/config.xml");
        UserDao dao=(UserDao) con.getBean("dao");
        User u=new User(1, "faisal", "ahmedabad");
//        dao.insertUser(u);
        System.out.println("data inserted");
        
        dao.getUserById(1);
    }
}
