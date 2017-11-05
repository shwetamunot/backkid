package niit.com.DaoImpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import niit.com.Dao.CategoryDao;
import niit.com.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public boolean addCategory(Category category) {
			try
			{
				Session session=sessionfactory.openSession();
			   session.beginTransaction();
		//		session.persist(category);
			// session.save(category);
				session.saveOrUpdate(category);
				session.getTransaction().commit();
		return true;
			}
		catch(Exception e)
		{
			return false;	
		}	
	}

	public List<Category> retrieveCategory() {

		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategory=query.list();
		session.close();
		return listCategory;


	}

	
	public boolean deleteCategory(Category category) {
	
		try
		{
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.delete(category);	
	session.getTransaction().commit();
	session.close();
	return true;
		}
	catch(Exception e)
	{
		return false;
	}
}
	
	public Category getCategory(int cId) {
	Session session=sessionfactory.openSession();
	Category category=(Category)session.get(Category.class,cId);
		session.close();
		return category;
	}

	public boolean UpdateCategory(Category category) {
		
		try
		{
			Session session=sessionfactory.openSession();
		session.beginTransaction();
			//sessionfactory.getCurrentSession().saveOrUpdate(category);	
	session.saveOrUpdate(category);
	session.getTransaction().commit();
	session.close();
		return true;
		}
	catch(Exception e)
	{
		return false;
	}
	}

}
