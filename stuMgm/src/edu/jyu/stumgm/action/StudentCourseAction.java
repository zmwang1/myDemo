package edu.jyu.stumgm.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.StudentCourseBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.StuCou;
import edu.jyu.stumgm.entity.TeacCou;
public class StudentCourseAction extends ActionSupport {

	private static final long serialVersionUID = 5478593221617299645L;
	@SuppressWarnings("unused")
	private List<Course> courselist;
	private List<TeacCou> teacCoulist;
	private List<StuCou> stuCoulist;
	public List<StuCou> getStuCoulist() {
		return stuCoulist;
	}
	public void setStuCoulist(List<StuCou> stuCoulist) {
		this.stuCoulist = stuCoulist;
	}
	private String TeacCouids="";
	private String studentid="";
	private String stuCouids="";
	private CourseBO courseBO;
	private StudentCourseBO studentCourseBO;
	public List<TeacCou> getTeacCoulist() {
		return teacCoulist;
	}
	public void setTeacCoulist(List<TeacCou> teacCoulist) {
		this.teacCoulist = teacCoulist;
	}
	public void setStudentCourseBO(StudentCourseBO studentCourseBO) {
		this.studentCourseBO = studentCourseBO;
	}
	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public List<Course> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	private String flag="";
	public String getStuCouids() {
		return stuCouids;
	}
	public void setStuCouids(String stuCouids) {
		this.stuCouids = stuCouids;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getTeacCouids() {
		return TeacCouids;
	}
	public void setTeacCouids(String teacCouids) {
		TeacCouids = teacCouids;
	}
	@SuppressWarnings("null")
	public String all()
	{	
		//得到学生的选课列表
		stuCoulist=studentCourseBO.getCourseByStudentId(studentid);
		//得到所有已分配老师的课程列表
		courselist=courseBO.getAllCourse();
		List<String> list=new ArrayList<String>();
		System.out.println("StudentCourseAction.courseid"+studentid);
		System.out.println("StudentCourseAction.courseid"+stuCoulist);
		if(stuCoulist!=null){
			for(StuCou c:stuCoulist){
				String courseid=c.getTeacCou().getCourse().getCourseId();
				System.out.println("StudentCourseAction.courseid"+courseid);
				list.add(courseid);
			}
			//得到学生可选的课程列表  not in
			teacCoulist=studentCourseBO.getTeacCouByCourseId(list);
		}else{
			for(Course c:courselist){
				String courseid=c.getCourseId();
				list.add(courseid);
			}
			teacCoulist=studentCourseBO.getAllTeacCouByCourseId(list);
		}
		
		return "mylist";
		/*if(flag=="list" || flag.equals("list")){
			stuCoulist = studentCourseBO.getCourseByStudentId(studentid);
			return "look";
		}else{
			//得到学生的选课列表
			stuCoulist=studentCourseBO.getCourseByStudentId(studentid);
			//得到所有已分配老师的课程列表
			courselist=courseBO.getAllCourse();
			List<String> list=new ArrayList<String>();
			System.out.println("StudentCourseAction.courseid"+studentid);
			System.out.println("StudentCourseAction.courseid"+stuCoulist);
			if(stuCoulist!=null){
				for(StuCou c:stuCoulist){
					String courseid=c.getTeacCou().getCourse().getCourseId();
					System.out.println("StudentCourseAction.courseid"+courseid);
					list.add(courseid);
				}
				//得到学生可选的课程列表  not in
				teacCoulist=studentCourseBO.getTeacCouByCourseId(list);
			}else{
				for(Course c:courselist){
					String courseid=c.getCourseId();
					list.add(courseid);
				}
				teacCoulist=studentCourseBO.getAllTeacCouByCourseId(list);
			}
			return "list";
		}*/
	}
	
	public String AddCourseToStudent(){
		System.out.println("TeacherCourseAction.courseids"+TeacCouids);
		if (!"".equals(TeacCouids) && TeacCouids != null){
			String[] data = TeacCouids.split("[, ]");
			List<Integer> numbers = new ArrayList<Integer>();
			for(String s: data){
				System.out.println("TeacherCourseAction.AddCourseToTeacher"+s.toString());
				Integer TeacCouid=Integer.parseInt(s);
				numbers.add(TeacCouid);
			}
			System.out.println("TeacherCourseAction.teacherid"+studentid);
			studentCourseBO.addCourseByNumbers(numbers,studentid);;
		}
/*		stuCoulist = studentCourseBO.getCourseByStudentId(studentid);
		return SUCCESS;*/
		String str=this.all();
		return str;
	}
	public String deleteCourseToStudent(){
		if (!"".equals(stuCouids) && stuCouids != null){
			String[] data = stuCouids.split("[, ]");
			List<Integer> numbers = new ArrayList<Integer>();
			for(String s: data){
				System.out.println("TeacherCourseAction.deleteCourseToTeacher"+s.toString());
				Integer stuCou=Integer.parseInt(s);
				numbers.add(stuCou);
			}
			studentCourseBO.delectStudentCourse(numbers, studentid);
		}
/*		stuCoulist = studentCourseBO.getCourseByStudentId(studentid);
		return SUCCESS;*/
		String str=this.all();
		return str;
	}
}