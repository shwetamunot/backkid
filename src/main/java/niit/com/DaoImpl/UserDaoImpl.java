package niit.com.DaoImpl;
import niit.com.Dao.UserDao;

import niit.com.model.User;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")

public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionfac;
	
	public void insertUser(User user) {
	   
		Session session=sessionfac.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();

	}
	/*public UserDaoImpl()
	{
		
	}*/
	public UserDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionfac=sessionFactory;
	}
	
public boolean addUser(User user) {
	try
	{
		Session session=sessionfac.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	}

	public List<User> retrieveUser() {
	System.out.println("abc");
		Session session=sessionfac.openSession();
		Query query=session.createQuery("from User");
		List<User> listUser=query.list();
	
		session.close();
		return listUser;
	}
	public boolean deleteUser(User user) {
		try
		{
			Session session=sessionfac.openSession();
			System.out.println("abced");
			//sessionfac.getCurrentSession().delete(user);
			session.beginTransaction();
			session.delete(user);
		//	session.delete(user.getUseId());
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public User getUser(int useId) {
		Session session=sessionfac.openSession();
		User user=(User)session.get(User.class,useId);
		session.close();
		return user;
	}
	public boolean UpdateUser(User user) {
		try
		{
		sessionfac.getCurrentSession().saveOrUpdate(user);
		return true;
		}
		catch(Exception e)
		{
		return false;
	    }
	}
}
