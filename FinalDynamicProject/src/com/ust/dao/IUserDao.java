package com.ust.dao;
import java.util.List;

import com.ust.model.User;

public interface IUserDao {
	
	public abstract List<User> getAllDetails();
	public abstract User searchUserDetails(String searchString);
	public abstract User getUserById(int uId);
	
	//public abstract int disableUser(int uId);
	
	public abstract int insertUserDetails(User user);
	
	public abstract int updateUserDetails(User user);

}
