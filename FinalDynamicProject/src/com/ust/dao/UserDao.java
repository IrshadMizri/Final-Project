package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.User;

public class UserDao implements IUserDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<User> getAllDetails() {
		return template.query("select userid,username,password,roleid from login order by userid desc", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRoleid(rs.getInt(4)); 
				return user;
			}

		});
	}

	@Override
	public User searchUserDetails(String searchString) {
		String sql = "select userid,username,password,roleid from login where username=? ";
		return template.queryForObject(sql, new Object[] { searchString }, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User getUserById(int uId) {
		String sql = "select userid,username,password,roleid from login where userid=? ";
		return template.queryForObject(sql, new Object[] { uId }, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public int insertUserDetails(User user) {
		String sqlOne = "insert into login(username,password,roleid) values('" + user.getUsername() + "','"
				+ user.getPassword() + "',"+ user.getRoleid()+" ) ";

		return template.update(sqlOne);
	}

	@Override
	public int updateUserDetails(User user) {
		String sqlOne = "update login set username='" + user.getUsername() + "',password='" + user.getPassword()
				+ ",roleid="+user.getRoleid()+ "where userid=?";
		return template.update(sqlOne, new Object[] { user.getUserId() });
	}

}
