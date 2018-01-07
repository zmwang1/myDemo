package edu.jyu.stumgm.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.jyu.stumgm.Common;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.Student;
public class StudentLoginAction extends ActionSupport {
	private static final long serialVersionUID = -8515183406496049654L;
	private Logger logger = Logger.getLogger(StudentLoginAction.class);
	
	private String stuNumber= "";
	private boolean loginError = false;
	private StudentBO studentBO;
	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}


	public String getStuNumber() {
		return stuNumber;
	}


	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}


	public boolean isLoginError(){
		return loginError;
	}

	public String execute(){
		logger.info("login");
		//登录没登录 登录页面 studentlogin。do 页面显示不同  通过判断 session里的user 是否为空 来区别显示
		if(ActionContext.getContext().getSession().get("user") != null){
			return SUCCESS;
		}
		
		//走登录逻辑
		logger.info(stuNumber);
		if ("".equals(stuNumber)) {
			return SUCCESS;
		}
		Student user = studentBO.getStudentByNumber(stuNumber);

		logger.info("login: "+user);
		if(user != null){
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().getSession().put("isstudent", true);
			return SUCCESS;
		}
        
		//来到这里，说明没登录，但登录逻辑错误 ，loginerror 为true
		loginError = true;
		return SUCCESS;
	}

}