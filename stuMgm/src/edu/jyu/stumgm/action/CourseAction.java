package edu.jyu.stumgm.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.TeacherBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Teacher;

public class CourseAction extends ActionSupport{

	private static final long serialVersionUID = 2019471693629936441L;
	private Logger logger = Logger.getLogger(CourseAction.class);
	

	private String courseids = "";
	private Course course;
	private CourseBO courseBO;
	private String flag;
	private String courseid = "";
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	public String getCourseids() {
		return courseids;
	}
	public void setCourseids(String courseids) {
		this.courseids = courseids;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public CourseBO getCourseBO() {
		return courseBO;
	}
	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String add(){
		
		if(!"update".equals(flag)){
			courseid = courseBO.generateCourseNumber();
					return "add";
		}
		courseBO.addCourse(course);
		System.out.println("456");
		return "list";
	}
	
	public String edit(){
		if (!"update".equals(flag)) {
			course = courseBO.getCourseByNumber(courseid);
			logger.info(course.toString());
			return "edit";			
		}
		courseBO.updateCourse(course);
		return "list";
	}
	
	public String delete(){
		if (!"".equals(courseids)&& courseids != null){
			String[] data = courseids.split("[, ]");
			List<String> numbers = new ArrayList<String>();
			for(String s: data){
				numbers.add(s);
			}
			courseBO.deleteCourseByNumber(numbers);
		}
		return "list";
	}
	
}
