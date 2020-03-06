package edu.miu.apartment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/welcome" })
	public String welcome(Model model) {

		/*
		 * model.addAttribute("greeting",
		 * "Welcome to the Lone Ranger Company, Kimosabe!!");
		 * model.addAttribute("tagline",
		 * "The one and only place to work, so you can live and play!!");
		 */

		return "welcome";
	}

	@RequestMapping(value = "/homepage")
	public String home(Model model, Principal principal) {
		model.addAttribute("userinfo",principal.getName());
		return "homepage";
	}

	@RequestMapping(value = "/studentRegistration.html")
	public ModelAndView getStudentRegistrationPage(HttpServletResponse response) throws IOException {
		return new ModelAndView("studentRegistration");
	}

	@RequestMapping(value = "/dashboard.html")
	public ModelAndView getDashboard(HttpServletResponse response) throws IOException {
		return new ModelAndView("dashboard");
	}

	@RequestMapping(value = "/addNewBulding.html")
	public ModelAndView building(HttpServletResponse response) throws IOException {
		return new ModelAndView("addNewBulding");
	}
	@RequestMapping(value = "/addRoom.html")
	public ModelAndView room(HttpServletResponse response) throws IOException {
		return new ModelAndView("addRoom");
	}
	
	@RequestMapping(value = "/addEquipment.html")
	public ModelAndView addEquipment(HttpServletResponse response) throws IOException {
		return new ModelAndView("addEquipment");
	}
	
	@RequestMapping(value = "/addRoomEquipment.html")
	public ModelAndView addRoomEquipment(HttpServletResponse response) throws IOException {
		return new ModelAndView("addRoomEquipment");
	}

}
