package edu.jyu.stumgm.bo;
import java.util.List;

import edu.jyu.stumgm.dao.IStudentCourseDAO;
import edu.jyu.stumgm.dao.ITeacherCourseDAO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.StuCou;
import edu.jyu.stumgm.entity.TeacCou;


public class StudentCourseBO {

	private IStudentCourseDAO studentCourseDAO;
	private ITeacherCourseDAO teacherCourseDAO;
	public void setTeacherCourseDAO(ITeacherCourseDAO teacherCourseDAO) {
		this.teacherCourseDAO = teacherCourseDAO;
	}
	public void setStudentCourseDAO(IStudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}
	//根据课程id得到TeacCou
	public List<TeacCou> getTeacCouByCourseId(List<String> courseIds){
		List list=teacherCourseDAO.getTeacCouByCourseId(courseIds);
		return list;
	}
	public void addCourseByNumbers(List<Integer> numbers, String studentid) {
		// TODO Auto-generated method stub
		studentCourseDAO.addCourseToStudent(numbers, studentid);
	}
	public List<TeacCou> getAllTeacCouByCourseId(List<String> courseIds){
		List list=teacherCourseDAO.getAllTeacCouByCourseId(courseIds);
		return list;
	}
	public List<StuCou> getCourseByStudentId(String studentid) {
		// TODO Auto-generated method stub
		return studentCourseDAO.getCourseByStudentId(studentid);
	}
	public void delectStudentCourse(List<Integer> numbers, String studentid) {
		// TODO Auto-generated method stub
		studentCourseDAO.deleteStudentCourse(numbers, studentid);
	}
	
	
	
	
}
