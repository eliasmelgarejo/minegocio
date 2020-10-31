package com.minegocio.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

	@GetMapping("/")
	public String RedirectLogin(){
		return "redirect:/account/login";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "account/login";
	}
	
//	@PostMapping("/check")
//	public String Check(@ModelAttribute(name="credencial") Credencial credencial) {
//		
//		if(credencial.getUsername().equals(anObject))
//		return "users";
//	}
}
