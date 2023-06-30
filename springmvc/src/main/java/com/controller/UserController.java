package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	
	
	@RequestMapping("/")
	public String home(Model m) {
		List<User> list=dao.getAllUser();
		m.addAttribute("list", list);
		return "index";
		
		
	}
	
	@RequestMapping("/register")
	public String login() {
		return "register";
		
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about" ;
		
	}
//	@RequestMapping(value = "/insertuser" , method = RequestMethod.POST)
	
//	here @ModelAttribute is used for biniding the data which we enter in particular page.
//	RedirectView, the work of this class is it is used to redirect the page to the root page means it send
//	you to the main page from which you come .
	
	@RequestMapping(value = "/insertUser" , method = RequestMethod.POST)
	public RedirectView insertUser(@ModelAttribute User u,HttpServletRequest request) {
		dao.insertUser(u);
		RedirectView re=new RedirectView();
		re.setUrl(request.getContextPath()+"/");
		return re;
	}
	
	@RequestMapping(value = "/update/{id}")
	
//	@PathVariable is used for extract the id from data, means which data we have to extract from available data. 
//	ModelAndView is used for both model and view in from controller...
	public ModelAndView updateuser(@PathVariable("id") int id) {
		User u=dao.getUserById(id);
		System.out.println(u);
		ModelAndView mv= new ModelAndView();
		mv.addObject("u", u);
		mv.setViewName("update");
		return mv;
	}
	@RequestMapping(value = "/delete/{id}")
	public RedirectView deleteuser(@PathVariable("id") int id,HttpServletRequest request) {
		User u= dao.getUserById(id);
		dao.deleteUser(u);
		RedirectView re=new RedirectView();
		re.setUrl(request.getContextPath()+"/");
		return re;
		
	}

}
