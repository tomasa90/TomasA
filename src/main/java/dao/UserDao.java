package dao;

import entity.User;

import java.util.List;

public interface UserDao {

	List<User> getAll();
	
	void save(User user);
	
	User getById(int id);
	
	void update(User user);
	
	void delete(int id);
}
