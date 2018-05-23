package com.gc.spring.SpringPrepApr18;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	Person p;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "test", "Hello World!");
	}

	@RequestMapping("/form")
	public ModelAndView form(@RequestParam("fName") String firstName, @RequestParam("lName") String lastName) {
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return new ModelAndView("formresults", "test", p);
	}

	@RequestMapping("/test")
	public ModelAndView listOfPeople(Model model) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("Tim", "P"));
		list.add(new Person("Vicki", "R"));
		list.add(new Person("Jonah", "W"));
		list.add(new Person("John", "A"));
		
        model.addAttribute("htmlTagData", "<br/> creates a new line.");
        model.addAttribute("url", "http://www.grandcircus.co");
		return new ModelAndView("test", "test", list);
	}
}
