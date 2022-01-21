package com.example.parkingmanagementsystem.controller;

import java.util.List;

import com.example.parkingmanagementsystem.model.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.parkingmanagementsystem.repository.CarRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CarAppController {


	
	@Autowired
	private CarRepository dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model, HttpServletResponse response) {
	    List<CarEntity> listCar = dao.list();
	    model.addAttribute("listCar", listCar);

		//create a cookie
		Cookie cookie = new Cookie("Admin","Merve");
		Cookie cookie1 = new Cookie("User","user");

		cookie.setMaxAge(20);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setPath("/");

		cookie1.setMaxAge(20);
		cookie1.setSecure(true);
		cookie1.setHttpOnly(true);
		cookie1.setPath("/");

		response.addCookie(cookie);
		response.addCookie(cookie1);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		CarEntity car = new CarEntity();
		model.addAttribute("car", car);
		return "new_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("car") CarEntity car) {
		dao.save(car);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_form");
		CarEntity car = dao.get(id);
		mav.addObject("car", car);
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("car") CarEntity car) {
		dao.update(car);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id) {
		dao.delete(id);
		return "redirect:/";
	}

}
