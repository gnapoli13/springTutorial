package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Alien;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class HomeController {
	
	@GetMapping("/homepage")
	public String home(Model m) {
		m.addAttribute("nomeUtente", "Giovanni");
		return "home";
	}
	
	//http://localhost:8080/tutorial?nome=Giovanni
	@GetMapping("/tutorial")
	public String func(HttpServletRequest req, Model m) {
	
		m.addAttribute("nomeUtente", req.getParameter("nome"));
		return "home";
	}
	
	//http://localhost:8080/tutorial2?nome=Giovanni
	@GetMapping("/tutorial2")
	//se ci sono più parametri si può usare @RequestParam("nome")String nome
	public String func2(String nome, HttpSession session) {
	
		session.setAttribute("nomeUtente", nome);
		return "home";
	}
	//http://localhost:8080/tutorial3?nome=Giovanni
	@GetMapping("/tutorial3")
	public ModelAndView func3(@RequestParam("nome")String nome) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("nomeUtente", nome);
		return mv;
		
	}
	
	//http://localhost:8080/annotation?nome=Giovanni
	@GetMapping("/annotation")
	public String func1(@RequestParam String nome, Model m) {
		String n = nome;
	
		m.addAttribute("nomeUtente", n);
		return "home";
	}
	//http://localhost:8080/foos/Giovanni
	@GetMapping("/foos/{name}")
	public String getFoo(@PathVariable String name, Model m) {
		m.addAttribute("nomeUtente", name);
	    return "home";
	}
	
	
	//http://localhost:8080/object?aid=1&aname=Giovanni&lang=bitontese
	@GetMapping("/object")
	public ModelAndView mv(Alien a) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alien");
		mv.addObject("oggetto", a);
		return mv;
	}
	
	

}
