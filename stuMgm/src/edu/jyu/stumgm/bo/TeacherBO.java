package edu.jyu.stumgm.bo;

import java.util.Calendar;
import java.util.List;

import edu.jyu.stumgm.dao.ITeacherDAO;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.Teacher;

public class TeacherBO {

	private ITeacherDAO teacherDAO;

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	//添加老师
	public void addTeacher (Teacher teacher){
		teacherDAO.save(teacher);
		System.out.println("BO"+teacher.getId()+" ,"+teacher.getEmail()+" ,"+teacher.getGender()+" ,"
				+teacher.getName()+" ,"+teacher.getPasswd()+" ,"+teacher.getPhone());
	}
	/**
	 * 得到所有的Teacher列表
	 * @return @
	 */
	public List<Teacher> getAllTeachers() {
		return teacherDAO.findAll();

	}
	//按ID获取老师信息
	public Teacher getTeacherByNumber(String teacherId) {
		System.out.println("getTeacherByNumber " + teacherId);
		return teacherDAO.get(teacherId);
	}
	//更新老师信息
	public void updateTeacher(Teacher teacher) {
		teacherDAO.update(teacher);
	}
	
	/**
	 * 删除Teacher
	 * @param STUID
	 */
	public void deleteTeacher(String teacherid) {
		teacherDAO.delete(teacherid);
	}
	
	public void deleteTeacherByNumber(List<String> numbers){
		teacherDAO.deleteByNumbers(numbers);
	}
	/**
	 * 查询老师
	 */
	public List<Teacher> fineTeacherByKey(String key){
		return teacherDAO.findByKey(key);
	}
	/**
	 * 生成teacherID，前二位是年份，后六位是随机数
	 * @return @
	 */
	public String generateTeachNumber() {
		Calendar calendar = Calendar.getInstance();
		String teachNumber = "";
		String teach="";
		int done = 1;
		while (done == 1) {
			teachNumber = "";
			teachNumber += calendar.get(Calendar.YEAR);
			teach=teachNumber.substring(2, teachNumber.length());
			double rand = Math.random() * 900000;
			long teachID = (long) (rand) + 100000;
			teach += teachID;

			if (!isExistTeachNumber(teach)) {
				done = 0;
			}
		}
		return teach;

	}

	/**
	 *判断教工号是否存在
	 */
	private boolean isExistTeachNumber(String teacherNumber) {
		return teacherDAO.get(teacherNumber) != null;
	}
	
	
}
