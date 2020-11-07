package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

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
	//req handling method to show vendor reg form : using form binding techniqe
	@GetMapping("/register")
	public String showRegForm(Vendor v)//binding POJO to form data n adding it model map
	{
		System.out.println("in show reg form ");
		//map.addAttribute("vendor",dao.getVendorDtls(vid));
		return "/admin/register";
	}
	//req handling method to process vendor reg form
		@PostMapping("/register")
		public String processregForm(@Valid Vendor v,BindingResult result,  RedirectAttributes flashMap,Model map)
		{
			System.out.println("in process reg form "+v);
			//chk P.L errs
			if(result.hasErrors())
			{
				System.out.println("P.L errs "+result);
				//forward clnt to view layer --reg form
				return "/admin/register";
				
			}
			System.out.println("No P.L errors...");
			System.out.println("model map "+map);
			//v --- transient
			flashMap.addFlashAttribute("mesg",dao.registerNewVendor(v));
			return "redirect:/admin/list";
		}
		//req handling method to delete vendor details
		@GetMapping("/delete")
		public String deleteVendorDtls(@RequestParam int vid,RedirectAttributes flashMap)
		{
			System.out.println("in del vendor dtls "+vid);
			//invoke dao's method
			flashMap.addFlashAttribute("mesg",dao.deleteVendor(vid));
			return "redirect:/admin/list";
		}
	
	
	
}
