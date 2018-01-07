package edu.jyu.stumgmTest.EntityTest;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.jyu.stumgm.dao.ITeacherCourseDAO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.TeacCou;

public class test {

	private static ApplicationContext ac=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Calendar calendar = Calendar.getInstance();
//		String stuNumber = "";
//		String stu="";
//		int done = 1;
//			stuNumber = "";
//			stuNumber += calendar.get(Calendar.YEAR);
//			stu=stuNumber.substring(2, stuNumber.length());
////			long stuID = (long) (Math.random() * 1000000);
//			double rand =Math.random() * 900000;
//			long stuID = (long) (rand) + 100000;
//			stu += stuID;
//
//		
//		System.out.println(stu);
//		
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ITeacherCourseDAO teacherCourseDAO=(ITeacherCourseDAO) ac.getBean("teacherCourseDAO");
		String id="17491974";
		List<Course> list=teacherCourseDAO.getCourseByTeacherId(id);
		
		System.out.println(list.get(0).getCourseName()+",");

	}

}
