package edu.jyu.stumgm.dao;


import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.TeacCou;
import edu.jyu.stumgm.entity.Teacher;


public class TeacherCourseDAO extends BaseDAO implements ITeacherCourseDAO{


	private ITeacherDAO teacherDAO;
	private ICourseDAO courseDAO;
	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TeacherCourseDAO() {
		// TODO Auto-generated constructor stub
		super(TeacCou.class);
	}
	
	@Override
	public void deleteByNumbers(List<String> numbers) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.createQuery("delete from TeacCou t where t.id in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	@Override
	public void save(TeacCou teacCou) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(teacCou);
		tx.commit();
		session.close();
	}
	@Override
	public TeacCou get(Serializable id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(TeacCou.class);
		criteria.add(Restrictions.eq("id", id));
		List<TeacCou> res = (List<TeacCou>)criteria.list();
		if(res==null||res.isEmpty()) return null;
		return res.get(0);
	}
	@Override
	public void update(TeacCou teacCou) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(teacCou);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		TeacCou teacCou=new TeacCou();
		int couid=Integer.parseInt(id);
		teacCou.setId(couid);
		template.delete(teacCou);	
	}
	@Override
	public List<TeacCou> findByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(TeacCou teacCou) {
		// TODO Auto-generated method stub
		
	}
	//通过老师id得到课程
	@Override
	public List<Course> getCourseByTeacherId(String teacherid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println(teacherid);
		Query query=session.createQuery("from Course as c where c.courseId in (select t.course.courseId from TeacCou as t where t.teacher.id=?)");
		query.setString(0, teacherid);
		List list=query.list();
		System.out.println(list.size());
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
		
	}
	public void addCourseToTeacher(List<String> numbers,String teacherId){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		for(String s:numbers){
			Teacher teacher=teacherDAO.get(teacherId);
			TeacCou teacCou=new TeacCou();
			Course course=courseDAO.get(s);
			teacCou.setCourse(course);
			teacCou.setTeacher(teacher);
			session.save(teacCou);
		}
		tx.commit();
		session.close();
	}
	//删除教师课程
	public void deleteTeacherCourse(List<String> numbers,String teacherid){
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("delete from TeacCou as t where t.course.courseId in (:n) and t.teacher.id=:id").setParameterList("n", numbers).setString("id", teacherid);
		query.executeUpdate();
	}
	@Override
	public List<TeacCou> getTeacCouByCourseId(List<String> courseid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("from TeacCou as t where t.course.courseId not in (:id)").setParameterList("id", courseid);
		List list=query.list();
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
		
	}
	@Override
	public List<TeacCou> getAllTeacCouByCourseId(List<String> courseIds) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("from TeacCou as t where t.course.courseId in (:id)").setParameterList("id", courseIds);
		List list=query.list();
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}



}