package niit.com.DaoImpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import niit.com.Dao.SupplierDao;
import niit.com.model.Supplier;
@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionfactory;
	public boolean addSupplier(Supplier supplier) {
		try
		{
			Session session=sessionfactory.openSession();
			
	//sessionfactory.getCurrentSession().save(supplier);
	session.beginTransaction();
	session.saveOrUpdate(supplier);
	session.getTransaction().commit();
	return true;
		}
		catch(Exception e)
		{
		return false;
     	}
		}
	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			
Session session=sessionfactory.openSession();
session.beginTransaction();
session.delete(supplier);
	//	sessionfactory.getCurrentSession().delete(supplier);	
session.getTransaction().commit();
session.close();
return true;
		}
		catch(Exception e)
		{
			return false;
	
		}
			}

	public Supplier getSupplier(int sId) {
		
		Session session=sessionfactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,sId);
		session.close();
		return supplier;
	}
	public boolean UpdateSupplier(Supplier supplier) {
		try
		{
			Session session=sessionfactory.openSession();
	 //   sessionfactory.getCurrentSession().saveOrUpdate(supplier);		
	    session.beginTransaction();
	    session.saveOrUpdate(supplier);
	    session.getTransaction().commit();
	    session.close();
	    return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

public List<Supplier> retrieveSupplier() {
	Session session=sessionfactory.openSession();
   Query query=session.createQuery("from Supplier");
	List<Supplier> listSupplier=query.list();
	session.close();
	return listSupplier;
	
}
	

}
