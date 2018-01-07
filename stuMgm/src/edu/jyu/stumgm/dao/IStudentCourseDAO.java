package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.StuCou;

public interface IStudentCourseDAO {
	public void save(StuCou stuCou);

	public StuCou get(Serializable id);
	
	public void update(StuCou stuCou);

	public void delete(StuCou stuCou);

	public void delete(String id);
	
	public List<StuCou> findAll();
	
	/**
	 * 根据key进行模糊匹配查找
	 * @param key
	 * @return
	 */
	public List<StuCou> findByKey(String key);

	public void deleteByNumbers(List<String> numbers);
	/**
	 * 根据老师ID显示课程
	 */
	public List<StuCou> getCourseByStudentId(String stuid);
	public void addCourseToStudent(List<Integer> numbers,String stuId);
	public void deleteStudentCourse(List<Integer> numbers,String stuid);
}