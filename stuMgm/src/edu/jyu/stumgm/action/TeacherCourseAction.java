package edu.jyu.stumgm.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.TeacherCourseBO;
import edu.jyu.stumgm.entity.Course;
public class TeacherCourseAction extends ActionSupport {

	private static final long serialVersionUID = 5478593221617299645L;
	@SuppressWarnings("unused")
	private List<Course> courselist;
	private List<Course> courselist1;
	private List<Course> courselist2;
	private String teacherid="";
	private TeacherCourseBO teacherCourseBO;
	private CourseBO courseBO;
	private String courseids="";
	public String getCourseids() {
		return courseids;
	}
	public void setCourseids(String courseids) {
		this.courseids = courseids;
	}
	public List<Course> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	public List<Course> getCourselist1() {
		return courselist1;
	}
	public void setCourselist1(List<Course> courselist) {
		this.courselist1 = courselist;
	}
	public List<Course> getCourselist2() {
		return courselist2;
	}
	public void setCourselist2(List<Course> courselist) {
		this.courselist2 = courselist;
	}
	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}
/*	private String flag="";
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}*/
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public void setTeacherCourseBO(TeacherCourseBO teacherCourseBO) {
		this.teacherCourseBO = teacherCourseBO;
	}
	public String all()
	{	
		/*if(flag.equals("my")){*/
			courselist1 = teacherCourseBO.getCourseByTeacherId(teacherid);
			
			List numbers=new ArrayList();
			if(courselist1!=null){
				for(Course c:courselist1){
					String s=c.getCourseId();
					numbers.add(s);
				}
				courselist2=courseBO.getCourse(numbers);
			}else{
				courselist2=courseBO.getAllCourse();
			}
			return "my";
		/*}
		if(flag.equals("list")){
			courselist = teacherCourseBO.getCourseByTeacherId(teacherid);
			return "list";
		}else {
			courselist = teacherCourseBO.getCourseByTeacherId(teacherid);
			List numbers=new ArrayList();
			if(courselist!=null){
				for(Course c:courselist){
					String s=c.getCourseId();
					numbers.add(s);
				}
				courselist=courseBO.getCourse(numbers);
			}else{
				courselist=courseBO.getAllCourse();
			}
			return "add";
		}*/
	}
	public String AddCourseToTeacher(){
		System.out.println("TeacherCourseAction.courseids"+courseids);
		if (!"".equals(courseids) && courseids != null){
			String[] data = courseids.split("[, ]");
			List<String> numbers = new ArrayList<String>();
			for(String s: data){
				System.out.println("TeacherCourseAction.AddCourseToTeacher"+s.toString());
				numbers.add(s);
			}
			System.out.println("TeacherCourseAction.teacherid"+teacherid);
			teacherCourseBO.addCourseByNumbers(numbers,teacherid);;
		}
		//courselist1 = teacherCourseBO.getCourseByTeacherId(teacherid);
		String str=this.all();
		return str;
	}
	public String deleteCourseToTeacher(){
		if (!"".equals(courseids) && courseids != null){
			String[] data = courseids.split("[, ]");
			List<String> numbers = new ArrayList<String>();
			for(String s: data){
				System.out.println("TeacherCourseAction.deleteCourseToTeacher"+s.toString());
				numbers.add(s);
			}
			teacherCourseBO.delectTeacherCourse(numbers, teacherid);
		}
		courselist = teacherCourseBO.getCourseByTeacherId(teacherid);
		return "list";
	}
}