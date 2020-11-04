package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IBankAccountDao;
import com.app.pojos.AcType;
import com.app.pojos.BankAccount;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/acct")
public class BankAccountController {
	@Autowired
	private IBankAccountDao dao;
	public BankAccountController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// req handling method to show a/c opening form
	@GetMapping("/create")
	public String showAcOpeningForm(Model map) {
		System.out.println("in show a/c open form");
		map.addAttribute("ac_types", AcType.values());
		return "/acct/create";
	}

	// req handling method to process a/c opening form
	@PostMapping("/create")
	public String processAcOpeningForm(@RequestParam AcType ac_type,
			@RequestParam double balance,
			RedirectAttributes flashMap,HttpSession hs) {
		System.out.println("in show a/c open form");
		//create transient a/c pojo
		BankAccount a=new BankAccount(balance, ac_type);
		//link it with vendor from HS scope
		Vendor v=(Vendor)hs.getAttribute("user_dtls");
		// v --- detached
		//a --- transient
		v.addAccount(a);//bi dir asso -- changing state of detached pojo
		//invoke dao's method
		flashMap.addFlashAttribute("mesg",dao.createAccount(v));
		//redirect clnt to vendor details page
		return "redirect:/vendor/details";
	}

}
