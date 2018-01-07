package edu.jyu.stumgm.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.bo.TeacherBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.Teacher;

public class CourseListAction extends ActionSupport {

	private static final long serialVersionUID = 4014616454393051198L;
	private List<Course> courselist;
	private CourseBO courseBO;
	public List<Course> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	public CourseBO getCourseBO() {
		return courseBO;
	}
	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}
	public String execute()
	{	
		courselist = courseBO.getAllCourse();
		return SUCCESS;
	}
}