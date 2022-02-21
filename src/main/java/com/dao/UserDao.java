package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addUser(UserBean user) {
		
		
		stmt.update("insert into users(firstname,email,password,phoneno,address,city,state,pincode,roleid,isactive) "
				+ "values(?,?,?,?,?,?,?,?,?,?)",user.getFirstName(),user.getEmail(),user.getPassword(),user.getPhoneNo(),
				user.getAddress(),user.getCity(),user.getState(),user.getPincode(),user.getRoleId(),1);
		
	}
	
	public List<UserBean> getAllUsers() {
		
		List<UserBean> users = stmt.query("select u.*,r.rolename from users u,role r where u.roleid = r.roleid",
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
	
		return users;
	}
	
	public void deleteRole(int userId) {
		
		stmt.update("delete from users where userid = ?",userId);
	}
	
	public UserBean getUserById(int userId) {
		
		UserBean user = stmt.queryForObject("select u.*,r.rolename from users u,role r where u.roleid=r.roleid and userid = ?", 
				new BeanPropertyRowMapper<UserBean>(UserBean.class),new Object[] {userId});
		
		return user;
	}
	
	public void updateUser(UserBean user) {
		
		stmt.update("update users set firstname=?,email=?,password=?,phoneno=?,address=?,city=?,state=?,pincode=?,"
				+ "isactive=? where userid=?",user.getFirstName(),user.getEmail(),user.getPassword(),user.getPhoneNo(),user.getAddress(),
				user.getCity(),user.getState(),user.getPincode(),user.getIsActive(),user.getUserId());
		
	}
	
}