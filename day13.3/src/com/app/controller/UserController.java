package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency -- DAO layer i/f
	@Autowired
	private IUserDao dao;

	@PostConstruct
	public void myInit() {
		System.out.println("in init of " + getClass().getName() + " " + dao);
	}

	// req handling method to show login form
	@GetMapping("/login") // @RequestMapping(method = RequestMethod.GET)
	public String showLoginForm() {
		System.out.println("in show loging form");
		return "/user/login";
	}

	// req handling method to process login form
	@PostMapping("/login") // @RequestMapping(method = RequestMethod.POST)
	public String processLoginForm(@RequestParam String email, 
			@RequestParam(name = "password") String pass, Model map,
			HttpSession hs, RedirectAttributes flashMap) {
		// String email=request.getParameter("email");
		System.out.println("in process login form " + email + " " + pass);
		// validate user from DB
		try {
			// invoke Dao's method
			Vendor v = dao.validateUser(email, pass);
			// add a mesg -- login successful as per role --
			flashMap.addFlashAttribute("mesg", v.getUserRole() + " : Login Successful");
			// successful login --chk role
			// add user dtls under model map ---session scope
			hs.setAttribute("user_dtls", v);// entire session

			if (v.getUserRole().equals(Role.ADMIN))
				return "redirect:/admin/list";
			
			return "redirect:/vendor/details";

		} catch (RuntimeException e) {
			//e.printStackTrace();
			// invalid login --forward clnt to login form
			// add err mesg under model map
			map.addAttribute("mesg", "Invalid Login , Pls retry ...");
			return "/user/login";

		}

	}

	// request handling method for user's logout
	@GetMapping("/logout")
	public String logMeOut(HttpSession hs, Model map, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in user logout");
		// get user dtls from HS & add them in model map
		map.addAttribute("details", hs.getAttribute("user_dtls"));
		// discard session
		hs.invalidate();
		// auto navigate the clnt to home page after some dly
		response.setHeader("refresh", "5;url="+request.getContextPath());
		return "/user/logout";
	}
}
