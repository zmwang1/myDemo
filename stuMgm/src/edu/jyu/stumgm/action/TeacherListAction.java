package edu.jyu.stumgm.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.bo.TeacherBO;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.Teacher;

public class TeacherListAction extends ActionSupport {

	private static final long serialVersionUID = 4014616454393051198L;
	private List<Teacher> teacherlist;
	private TeacherBO teacherBO;
	public List<Teacher> getTeacherlist() {
		return teacherlist;
	}
	public void setTeacherlist(List<Teacher> teacherlist) {
		this.teacherlist = teacherlist;
	}
	public TeacherBO getTeacherBO() {
		return teacherBO;
	}
	public void setTeacherBO(TeacherBO teacherBO) {
		this.teacherBO = teacherBO;
	}
	public String execute()
	{	
		teacherlist = teacherBO.getAllTeachers();
		return SUCCESS;
	}
}