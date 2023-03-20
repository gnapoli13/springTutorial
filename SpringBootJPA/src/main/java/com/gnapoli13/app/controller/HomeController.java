package com.gnapoli13.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gnapoli13.app.dao.AlienDao;
import com.gnapoli13.app.model.Alien;



@Controller
public class HomeController {
	@Autowired
	AlienDao dao;
	
	@GetMapping("/")
	String home(){
		return "home";
	}
	@GetMapping("/addAlien")
	String addAlien(Alien a) {
		dao.save(a);
		System.out.println(a);
		return "home";
	}
	
	@PostMapping("/findId")
	String find(@RequestParam int aid, Model m) {
		m.addAttribute("alien",dao.findById(aid));
		return "home";
	}
	
	@PostMapping("/findTech")
	String find(@RequestParam String tech, Model m) {
		m.addAttribute("alien",dao.myquery(tech));
		return "home";
	}

}
