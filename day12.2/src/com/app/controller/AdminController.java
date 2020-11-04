package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IVendorDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IVendorDao dao;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// req handling method for listing vendor dtls
	@GetMapping("/list")
	public String listVendors(Model map) {
		System.out.println("in list vndrs");
		map.addAttribute("vendor_list", dao.listVendors());
		return "/admin/list";
	}
	//req handling method to show vendor reg form
	@GetMapping("/register")
	public String showRegForm()
	{
		System.out.println("in show reg form");
		return "/admin/register";
	}
	//req handling method to process vendor reg form
		@PostMapping("/register")
		public String processregForm()
		{
			//To be continued.....
			//dao.registerNewVendor(v);
			return "redirect:/admin/list";
		}
		//req handling method to delte vendor details
		@GetMapping("/delete")
		public String deleteVendorDtls(@RequestParam int vid,RedirectAttributes flashMap)
		{
			System.out.println("in del vendor dtls "+vid);
			//invoke dao's method
			flashMap.addFlashAttribute("mesg",dao.deleteVendor(vid));
			return "redirect:/admin/list";
		}
	
	
	
}
