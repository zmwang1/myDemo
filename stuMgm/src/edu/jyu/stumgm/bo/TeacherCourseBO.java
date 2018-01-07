package edu.jyu.stumgm.bo;
import java.util.List;

import edu.jyu.stumgm.dao.ITeacherCourseDAO;
import edu.jyu.stumgm.entity.Course;


public class TeacherCourseBO {

	private ITeacherCourseDAO teacherCourseDAO;
	public void setTeacherCourseDAO(ITeacherCourseDAO teacherCourseDAO) {
		this.teacherCourseDAO = teacherCourseDAO;
	}
	//根据老师ID显示他的课程
	public List<Course> getCourseByTeacherId(String teacherId){
		List<Course> list= teacherCourseDAO.getCourseByTeacherId(teacherId);
		return list;
	}
	//添加课程
	public void addCourseByNumbers(List<String> numbers,String teacherid){
		System.out.println("TeacherCourseBO.numbers.size()"+numbers.size()+"");
		System.out.println("TeacherCourseBO.addCourseByNumbers"+teacherid);
		teacherCourseDAO.addCourseToTeacher(numbers, teacherid);
	}
	public void delectTeacherCourse(List<String> numbers,String teacherid){
		teacherCourseDAO.deleteTeacherCourse(numbers, teacherid);
	}
	
	
	
}
