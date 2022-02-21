package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.RoleBean;
import com.bean.UserBean;
import com.dao.RoleDao;
import com.dao.UserDao;

@Controller
public class UserController {
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	UserDao userDao;

	@GetMapping("/newuser")
	public String newUser(Model model) {
		
		List<RoleBean> roles = roleDao.getAllRoles();
		model.addAttribute("roles",roles);
		
		return "NewUser";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		
		userDao.addUser(user);
		
		return "redirect:/listusers";
	}
	
	@GetMapping("/listusers")
	public String getAllUsers(Model model) {
		
		List<UserBean> users =  userDao.getAllUsers();
		model.addAttribute("users",users);
		
		return "ListUsers";
		
	}
	
	@GetMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		
		userDao.deleteRole(userId);
		
		return "redirect:/listusers";
		
	}
	
	@GetMapping("/edituser")
	public String editUser(@RequestParam("userId") int userId,Model model) {
		
		UserBean user = userDao.getUserById(userId);
		model.addAttribute("user",user);
		
		return "EditUser";
		
	}
	
	@PostMapping("/updateuser")
	public String updateUser(UserBean user) {
		
		userDao.updateUser(user);
		
		return "redirect:/listusers";
	}
	
	
}
