package edu.jyu.stumgm.bo;

import java.util.Calendar;
import java.util.List;

import edu.jyu.stumgm.dao.ICourseDAO;
import edu.jyu.stumgm.entity.Course;

public class CourseBO {

	private ICourseDAO courseDAO;

	
	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	//添加课程
	public void addCourse (Course course){
		courseDAO.save(course);
	}
	/**
	 * 得到所有的Course列表
	 * @return @
	 */
	public List<Course> getAllCourse() {
		return courseDAO.findAll();

	}
	//按ID获取课程信息
	public Course getCourseByNumber(String courseId) {
		return courseDAO.get(courseId);
	}
	//更新课程信息
	public void updateCourse(Course course) {
		courseDAO.update(course);
	}
	
	/**
	 * 删除Course
	 * @param STUID
	 */
	public void deleteCourse(String courseId) {
		courseDAO.delete(courseId);
	}
	
	public void deleteCourseByNumber(List<String> numbers){
		courseDAO.deleteByNumbers(numbers);
	}
	/**
	 * 查询课程
	 */
	public List<Course> fineCourseByKey(String key){
		return courseDAO.findByKey(key);
	}
	public List<Course> getCourse(List<String> numbers){
		return courseDAO.getCourse(numbers);
	}
	/**
	 * 生成teacherID，前二位是年份，后六位是随机数
	 * @return @
	 */
	public String generateCourseNumber() {
		Calendar calendar = Calendar.getInstance();
		String courseNumber = "";
		String course="";
		int done = 1;
		while (done == 1) {
			courseNumber = "";
			courseNumber += calendar.get(Calendar.YEAR);
			course=courseNumber.substring(2, courseNumber.length());
			double rand = Math.random() * 900000;
			long teachID = (long) (rand) + 100000;
			course += teachID;

			if (!isExistCourseNumber(course)) {
				done = 0;
			}
		}
		return course;

	}

	/**
	 *判断教工号是否存在
	 */
	private boolean isExistCourseNumber(String courseNumber) {
		return courseDAO.get(courseNumber) != null;
	}
	
	
}
