package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorDao dao;

	@PostConstruct
	public void myInit() {
		System.out.println("in init of " + getClass().getName() + " " + dao);
	}

	// request handling method to display vendor details
	@GetMapping("/details")
	public String showVendorDtls(HttpSession hs) {
		System.out.println("in show vndr dtls");
		//get vendor dtls from session scope --for vendor id
		Vendor v = (Vendor) hs.getAttribute("user_dtls");
		//get complete details from DB --vendor + bank accts
		hs.setAttribute("user_dtls", dao.getCompleteDetails(v.getId()));
		return "/vendor/details";
	}

}
