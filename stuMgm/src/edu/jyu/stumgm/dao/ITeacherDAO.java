package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;
import edu.jyu.stumgm.entity.Teacher;

public interface ITeacherDAO {
	public void save(Teacher teacher) ;

	public Teacher get(Serializable id) ;
	
	public void update(Teacher teacher) ;

	public void delete(Teacher teacher);

	public void delete(String id);
	
	public List<Teacher> findAll();
	
	/**
	 * 根据key进行模糊匹配查找
	 * @param key
	 * @return
	 */
	public List<Teacher> findByKey(String key);

	public void deleteByNumbers(List<String> numbers);
}