package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started........." );
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//       ApplicationContext context=new AnnotationConfigApplicationContext(Jdbc_JavaConfig.class);
        StudentDaoImpl studentDao= context.getBean("studentDaoImpl",StudentDaoImpl.class);

//      Insertion of data         
        Student obj=new Student();
        obj.setId(14);
        obj.setName("Ravi");
        obj.setCity("Hyd");
        int result=studentDao.insert(obj);
    System.out.println("No. of records inserted is "+result);
//----------------------------------------------------------------------------------------------------------
        //Updating the data in database
//        Student obj=new Student();
//        obj.setCity("Pitlam");
//        obj.setId(14);
//        obj.setName("Ramesh");
//        int result = studentDao.change(obj);
//        System.out.println("No of rows changed is "+result);
//----------------------------------------------------------------------------------------------------------
//        Deletion
//        int result = studentDao.delete(14);
//        System.out.println("No of rows deleted is "+result);
//----------------------------------------------------------------------------------------------------------
//        Selecting one particular student using RowMapper
        
//        Student student = studentDao.getStudent(11);
//        System.out.println(student);
//----------------------------------------------------------------------------------------------------------
        //Selecting all students using RowMapper
//       List<Student> allStudents = studentDao.getAllStudents();
//       for(Student obj:allStudents)
//    	   System.out.println(obj);
    }
}
