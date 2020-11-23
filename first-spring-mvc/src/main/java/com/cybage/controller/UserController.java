package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cybage.dao.UserDao;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/home")
	public String user() {
		return "user"; //user.jsp
	}
	
	@PutMapping("/user")
	@ResponseBody
	public String updateUser() {
		return "user updated successfully";
	}
	
	@GetMapping("/user")
	public String getUsers(Model model){
		model.addAttribute("users",userDao.getUsers());
		return "user";
	}
	
	@GetMapping("/user/{id}")
	@ResponseBody
	//public String getUser(@PathVariable int id, @RequestParam(required = true) String name){
	public ResponseEntity<String> getUser(@PathVariable int id) {
		return new ResponseEntity<String>("getting user with id: "+id,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteuser/{id}",method=RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
		userDao.deleteById(id);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/adduserform",method=RequestMethod.GET)
	public String adduserForm(Model model) {
		model.addAttribute("user",new Users());
		return "add-user-form";
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") Users user) {
		userDao.addUser(user);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/edituser/{id}",method=RequestMethod.GET)
	public String editUser(@PathVariable int id,Model model) {
		model.addAttribute("user",userDao.findById(id));
		return "edit-user";
	}
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") Users user) {
		userDao.updateUser(user);
		return "redirect:/user";
	}
}
