package edu.jyu.stumgm.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.entity.Course;

public class CourseSearchAction extends ActionSupport {

	private static final long serialVersionUID = 3820111387871613632L;
	private List<Course> courselist;
	private CourseBO courseBO;
	private String querystring;
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

	public String all()
	{
		courselist = courseBO.getAllCourse();
		return SUCCESS;
		
	}
	
	public String query()
	{
		List<Course> list;
		
		list = courseBO.getAllCourse();
		if(querystring!=null&&!querystring.equals("")){
			list=courseBO.fineCourseByKey(querystring);
		}
		courselist=list;
		return SUCCESS;
	}
	public String getQuerystring() {
		return querystring;
	}
	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}
}