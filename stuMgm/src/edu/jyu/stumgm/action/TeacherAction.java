package edu.jyu.stumgm.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.TeacherBO;
import edu.jyu.stumgm.entity.Teacher;

public class TeacherAction extends ActionSupport{

	private static final long serialVersionUID = 2019471693629936441L;
	private Logger logger = Logger.getLogger(TeacherAction.class);
	

	private String teachids = "";
	private Teacher teacher;
	private TeacherBO teacherBO;
	private String flag;
	private String teachid = "";
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getTeachid() {
		return teachid;
	}
	public void setTeachid(String teachid) {
		this.teachid = teachid;
	}
	public String getTeachids() {
		return teachids;
	}
	public void setTeachids(String teachids) {
		this.teachids = teachids;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setTeacherBO(TeacherBO teacherBO) {
		this.teacherBO = teacherBO;
	}
	
	public String add(){
		
		if(!"update".equals(flag)){
			teachid = teacherBO.generateTeachNumber();
					return "add";
		}
		System.out.println(teacher.getName());
		System.out.println(teacher.getId());
		teacherBO.addTeacher(teacher);
		System.out.println("456");
		return "list";
	}
	
	public String edit(){
		if (!"update".equals(flag)) {
			teacher = teacherBO.getTeacherByNumber(teachid);
			logger.info(teacher.toString());
			return "edit";			
		}
		teacherBO.updateTeacher(teacher);
		return "list";
	}
	
	public String delete(){
		if (!"".equals(teachids)&& teachids != null){
			String[] data = teachids.split("[, ]");
			List<String> numbers = new ArrayList<String>();
			for(String s: data){
				numbers.add(s);
			}
			teacherBO.deleteTeacherByNumber(numbers);
		}
		return "list";
	}
	
}
