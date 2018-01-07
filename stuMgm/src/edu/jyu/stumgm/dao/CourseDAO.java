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
import edu.jyu.stumgm.entity.Teacher;

public class CourseDAO extends BaseDAO<Course> implements ICourseDAO {

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CourseDAO() {
		// TODO Auto-generated constructor stub
		super(Course.class);
	}
	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(course);
		tx.commit();
		session.close();
	}

	@Override
	public Course get(Serializable id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		criteria.add(Restrictions.eq("id", id));
		List<Course> res = (List<Course>)criteria.list();
		if(res==null||res.isEmpty()) return null;
		return res.get(0);
	}

	@Override
	public void update(Course course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(course);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Course course=new Course();
		course.setCourseId(id);
		template.delete(course);	
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
//		criteria.add(Restrictions.eq("studentName", name));
		
		List<Course> list = (List<Course>)criteria.list();
		return list;
	}

	@Override
	public List<Course> findByKey(String key) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Course where courseId like '%'||?||'%' or courseName like '%'||?||'%'");
		query.setString(0, key);
		query.setString(1, key);
		List<Course> list=query.list();
		return list;
	}

	@Override
	public void deleteByNumbers(List<String> numbers) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.createQuery("delete from Course c where c.courseId in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	//根据id获取数据
	public List<Course> getCourse(List<String> numbers){
		Session session = sessionFactory.openSession();
		List list=session.createQuery("from Course as c where c.courseId not in (:n)").setParameterList("n", numbers).list();
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
		
	}

}
