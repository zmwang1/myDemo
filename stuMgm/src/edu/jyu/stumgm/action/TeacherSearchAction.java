package edu.jyu.stumgm.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.TeacherBO;
import edu.jyu.stumgm.entity.Teacher;


public class TeacherSearchAction extends ActionSupport {

	private static final long serialVersionUID = 3820111387871613632L;
	private List<Teacher> teacherlist;
	private TeacherBO teacherBO;
	private String querystring;
	
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

	public String all()
	{
		teacherlist = teacherBO.getAllTeachers();
		return SUCCESS;
		
	}
	
	public String query()
	{
		List<Teacher> list;
		
		list = teacherBO.getAllTeachers();
		if(querystring!=null&&!querystring.equals("")){
			list=teacherBO.fineTeacherByKey(querystring);
		}
		teacherlist=list;
		return SUCCESS;
	}
	public String getQuerystring() {
		return querystring;
	}
	public void setQuerystring(String querystring) {
		this.querystring = querystring;
	}
}