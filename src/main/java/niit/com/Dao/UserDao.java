package niit.com.Dao;
import java.util.List;


import niit.com.model.*; 

public interface UserDao {
	
public void insertUser(User user);
public boolean addUser(User user);
public List<User> retrieveUser();
public boolean deleteUser(User user);
public User getUser(int useId);
public boolean UpdateUser(User user);
}
