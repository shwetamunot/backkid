package niit.com.hibernateConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import niit.com.Dao.UserDao;
import niit.com.DaoImpl.*;
import niit.com.model.*;

@Configuration
@ComponentScan("niit.com")
@EnableTransactionManagement

public  class HiberConfig
{
	
@Autowired
@Bean(name="dataSource")
public DataSource getH2DataSource()
{
	 System.out.println("Hibernate initiated..");
	 DriverManagerDataSource dm=new DriverManagerDataSource();
	 dm.setDriverClassName("org.h2.Driver");
	 dm.setUrl("jdbc:h2:tcp://localhost/~/mt");
	 dm.setUsername("sa");
	 dm.setPassword("");
  System.out.println("Connection Established");
 return dm;
 }
 private Properties getHiberProps()
 {
	 Properties p=new Properties();
	 p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	 p.put("hibernate.show_sql","true");
	 p.put("hibernate.hbm2ddl.auto","update");
	 System.out.println("Table created in H2");
	return p;
 }
 @Autowired
 @Bean(name="sessionFactory")
 public SessionFactory getSession()
 {
	 LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getH2DataSource());
	 lsfb.addProperties(getHiberProps());
	 lsfb.addAnnotatedClass(User.class);
	 lsfb.addAnnotatedClass(Category.class);
	lsfb.addAnnotatedClass(Product.class);
     lsfb.addAnnotatedClass(Supplier.class);
	 return lsfb.buildSessionFactory();
}

 @Autowired
 @Bean("userDao")
 public UserDaoImpl getUserDao(SessionFactory sessionfac)
 {
	 return new UserDaoImpl(sessionfac);	 
 }


 
 @Autowired
 @Bean(name="transactionManager")
public HibernateTransactionManager getTransaction(SessionFactory sessionfactory) 
{
	 HibernateTransactionManager tm=new HibernateTransactionManager(sessionfactory);
			 return tm;			 
}
 /*    public static void main(String args[])
 {
	 new HiberConfig().getSession();
 }
*/
}
