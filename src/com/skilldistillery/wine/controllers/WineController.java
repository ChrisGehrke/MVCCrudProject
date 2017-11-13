package com.skilldistillery.wine.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.wine.data.Wine;
import com.skilldistillery.wine.data.WineDAO;

@SessionAttributes("bestWine")
@Controller
public class WineController {

	@Autowired
	WineDAO dao;

	@ModelAttribute("bestWine")
	public Wine newWine() {
		return new Wine();
	}

	@RequestMapping("info.do")
	public ModelAndView getWineById(@RequestParam("id") Integer id)  {
		ModelAndView mv = new ModelAndView("info");
		Wine w = dao.getWineById(id);
		mv.addObject("wine", w);
		return mv;
	}
	@RequestMapping("delete.do")
	public ModelAndView delete(@RequestParam("id") Integer id)  {
		ModelAndView mv = new ModelAndView("deleted");
		
		Wine tasty = dao.getWineById(id);
		mv.addObject("name", tasty.getName());
		dao.deleteWine(tasty);
		
		return mv;
	}
	@RequestMapping(path="update.do", params="id")
	public ModelAndView update(@RequestParam("id") Integer id)  {
		ModelAndView mv = new ModelAndView("update");
		
		Wine tasty = dao.getWineById(id);
		mv.addObject("wine", tasty);
		
		return mv;
	}

	@RequestMapping(path = "getWine.do", method = RequestMethod.POST)
	public ModelAndView getWineByIdForm(@Valid @ModelAttribute("idForm")WineIdForm f, Errors e) {
		ModelAndView mv = new ModelAndView("index2");
		if(e.hasErrors()) {
			//go to the same page or an error page
			mv.setViewName("index2");
			return mv;
		}
		
		mv.setViewName("info");
		
		Wine w = dao.getWineById(f.getId());
		mv.addObject("wine", w);
		return mv;
	}

	public String home() {
		return "index";
	}

	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView homeWithValidation() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index2");
		WineIdForm f = new WineIdForm();
		mv.addObject("idForm", f);
		
		List<Wine> allWines= dao.getAllWines();
		mv.addObject("list", allWines);
		return mv;
	}
	
	@RequestMapping(path="add.do", method=RequestMethod.GET)
	public String addWine(Model model) {
		Wine w = new Wine();
		model.addAttribute("wine", w);
		
		return "add";
	}
	
	@RequestMapping(path= "addWine.do", method=RequestMethod.POST)
	public ModelAndView doAdd(@Valid Wine wine, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("add");
			return mv;
		}
		dao.addWine(wine);
		
		
		mv.setViewName("added");
		return mv;
	}
	@RequestMapping(path= "updateWine.do", method=RequestMethod.POST)
	public ModelAndView doUpdate(@Valid Wine wine, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("update");
			return mv;
		}
		dao.updateWine(wine);
		
		
		mv.setViewName("added");
		return mv;
	}
}
