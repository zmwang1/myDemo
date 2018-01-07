package edu.jyu.stumgmTest.EntityTest;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.TeacherBO;
import edu.jyu.stumgm.dao.CourseDAO;
import edu.jyu.stumgm.dao.ITeacherCourseDAO;
import edu.jyu.stumgm.entity.*;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class testTeacherBo{
	
	private static ApplicationContext ac=null;
	//测试得到所有课程
	@Test
	public void testgetAllTeachers() {
		ac=new ClassPathXmlApplicationContext("file:C:\\Users\\lenovo\\Desktop\\stuMgm\\WebContent\\WEB-INF\\applicationContext.xml");
		TeacherBO t=(TeacherBO) ac.getBean("teacherBO");
		List<Teacher> allteacher=t.getAllTeachers();
		System.out.println(allteacher);		
	}
	

}
