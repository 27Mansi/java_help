package com.cybage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppController {
	//@RequestMapping(value="/",method=RequestMethod.GET)
	@GetMapping(value={"/","/index"})
	public String welcome() {
		return "index";
	}
}
