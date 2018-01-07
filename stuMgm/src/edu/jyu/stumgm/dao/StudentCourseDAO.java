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
import edu.jyu.stumgm.entity.StuCou;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.TeacCou;
import edu.jyu.stumgm.entity.Teacher;


public class StudentCourseDAO extends BaseDAO implements IStudentCourseDAO{


	private IStudentDAO studentDAO;
	private ITeacherCourseDAO teacherCourseDAO;
	private SessionFactory sessionFactory;
	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public void setTeacherCourseDAO(ITeacherCourseDAO teacherCourseDAO) {
		this.teacherCourseDAO = teacherCourseDAO;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public StudentCourseDAO() {
		// TODO Auto-generated constructor stub
		super(StuCou.class);
	}
	
	@Override
	public void deleteByNumbers(List<String> numbers) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.createQuery("delete from TeacCou t where t.id in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		TeacCou teacCou=new TeacCou();
		int couid=Integer.parseInt(id);
		teacCou.setId(couid);
		template.delete(teacCou);	
	}
	//通过老师id得到课程
	@Override
	public List<StuCou> getCourseByStudentId(String stuid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println(stuid);
		Query query=session.createQuery("from StuCou as s where s.student.stuNumber = ?)");
		query.setString(0, stuid);
		List list=query.list();
		System.out.println(list.size());
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
		
	}
	@Override
	public void save(StuCou stuCou) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public StuCou get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(StuCou stuCou) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(StuCou stuCou) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<StuCou> findByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteStudentCourse(List<Integer> numbers, String stuid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("delete from StuCou as s where s.id in (:id) and s.student.stuNumber=:stuid").setParameterList("id", numbers).setString("stuid", stuid);
		query.executeUpdate();
	}

	@Override
	public void addCourseToStudent(List<Integer> numbers, String stuId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		for(Integer s:numbers){
			Student student=studentDAO.get(stuId);
			TeacCou teacCou=teacherCourseDAO.get(s);
			StuCou stuCou=new StuCou();
			stuCou.setTeacCou(teacCou);
			stuCou.setStudent(student);
			session.save(stuCou);
		}
		tx.commit();
		session.close();
	}
}