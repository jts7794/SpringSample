package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	// 로그인 화면의 GET용 컨트롤러
	@GetMapping("/login")
	public String getLogin(Model model) {
		
		// login.html로 화면 이동
		return "login/login";
	}
	
	// 로그인 화면의 POST용 컨트롤러
	@PostMapping("/login")
	public String postLogin(Model model) {
		
		// login.html로 화면 이동
		return "login/login";
	}
	
}
