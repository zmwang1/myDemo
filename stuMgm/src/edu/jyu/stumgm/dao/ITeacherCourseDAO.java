package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.TeacCou;

public interface ITeacherCourseDAO {
	public void save(TeacCou teacCou);

	public TeacCou get(Serializable id);
	
	public void update(TeacCou teacCou);

	public void delete(TeacCou teacCou);

	public void delete(String id);
	
	public List<TeacCou> findAll();
	
	/**
	 * 根据key进行模糊匹配查找
	 * @param key
	 * @return
	 */
	public List<TeacCou> findByKey(String key);

	public void deleteByNumbers(List<String> numbers);
	/**
	 * 根据老师ID显示课程
	 */
	public List<Course> getCourseByTeacherId(String teacherid);
	public void addCourseToTeacher(List<String> numbers,String teacherId);
	public void deleteTeacherCourse(List<String> numbers,String teacherid);
	public List<TeacCou> getTeacCouByCourseId(List<String> courseid);

	public List<TeacCou> getAllTeacCouByCourseId(List<String> courseIds);
}