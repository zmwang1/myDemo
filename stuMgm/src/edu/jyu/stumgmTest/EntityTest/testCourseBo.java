package edu.jyu.stumgmTest.EntityTest;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.dao.CourseDAO;
import edu.jyu.stumgm.dao.ITeacherCourseDAO;
import edu.jyu.stumgm.entity.*;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class testCourseBo{
	
	private static ApplicationContext ac=null;
	//测试得到所有课程
	@Test
	public void testgetAllCourse() {
		ac=new ClassPathXmlApplicationContext("file:C:\\Users\\lenovo\\Desktop\\stuMgm\\WebContent\\WEB-INF\\applicationContext.xml");
		CourseBO cb=(CourseBO) ac.getBean("courseBO");
		List<Course> allcourses=cb.getAllCourse();
		System.out.println(allcourses);		
	}
	

}
