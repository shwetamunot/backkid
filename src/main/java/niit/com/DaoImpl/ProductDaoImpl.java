package niit.com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import niit.com.Dao.ProductDao;
import niit.com.model.Product;

@Repository("productDao")
public class ProductDaoImpl  implements ProductDao{
@Autowired
SessionFactory sessionfactory;

	public boolean addProduct(Product product) {
	try
	{
		Session session=sessionfactory.openSession();
	System.out.println("abcd");
		session.beginTransaction();
	//sessionfactory.getCurrentSession().save(product);	
	session.persist(product);
session.getTransaction().commit();
	return true;
	}
	catch(Exception e)
	{
	return false;
	}
	}

	public List<Product> retrieveProduct() {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product>listProduct=query.list();
		session.close();
		return listProduct;
	}


	public Product getProduct(int proId) {
		Session session=sessionfactory.openSession();
		Product product=(Product)session.get(Product.class, proId);
	session.close();
	return product;
	}

	
	public boolean UpdateProduct(Product product) {
	try
	{
		sessionfactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	}
	
	
public boolean deleteProduct(Product product) {
	try
	{
		sessionfactory.getCurrentSession().delete(product);
	return true;
	}
	catch(Exception e)
	{
	return false;
}
}
}
