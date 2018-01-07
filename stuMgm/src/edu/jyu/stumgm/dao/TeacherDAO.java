package edu.jyu.stumgm.dao;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.Teacher;


public class TeacherDAO  extends BaseDAO<Teacher> implements ITeacherDAO{


	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TeacherDAO() {
		// TODO Auto-generated constructor stub
		super(Teacher.class);
	}
		
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Teacher teacher=new Teacher();
		teacher.setId(id);
		template.delete(teacher);		
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> findByKey(String key) {
		// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Teacher where id like '%'||?||'%' or name like '%'||?||'%' or gender like '%'||?||'%' or phone like '%'||?||'%' or email like '%'||?||'%'");
			query.setString(0, key);
			query.setString(1, key);
			query.setString(2, key);
			query.setString(3, key);
			query.setString(4, key);
			List<Teacher> list=query.list();
			return list;
		
	}

	@Override
	public void deleteByNumbers(List<String> numbers) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.createQuery("delete from Teacher t where t.id in (:n)").setParameterList("n", numbers).executeUpdate();
	}

	@Override
	public void save(Teacher teacher) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(teacher);
		tx.commit();
		session.close();
	}

	@Override
	public Teacher get(Serializable id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Teacher.class);
		criteria.add(Restrictions.eq("id", id));
		List<Teacher> res = (List<Teacher>)criteria.list();
		if(res==null||res.isEmpty()) return null;
		return res.get(0);
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(teacher);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Teacher.class);
//		criteria.add(Restrictions.eq("studentName", name));
		
		List<Teacher> list = (List<Teacher>)criteria.list();
		return list;
	}

}