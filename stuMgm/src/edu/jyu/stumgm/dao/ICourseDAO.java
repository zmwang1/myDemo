package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Course;

public interface ICourseDAO {
	public void save(Course course) ;

	public Course get(Serializable id) ;
	
	public void update(Course course) ;

	public void delete(Course course);

	public void delete(String id);
	
	public List<Course> findAll();
	
	/**
	 * 根据key进行模糊匹配查找
	 * @param key
	 * @return
	 */
	public List<Course> findByKey(String key);

	public void deleteByNumbers(List<String> numbers);
	public List<Course> getCourse(List<String> numbers);
}