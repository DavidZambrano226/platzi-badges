/**
 * 
 */
package com.platzi.ereservation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Se utilizar para controlar el login personalizado
 * @author GERZON ZAMBRANO
 *
 */

@Controller
@RequestMapping("app")
public class LoginController {
	@GetMapping(value= {"/login", "/"})
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		String errorMessage = "Usuario no autorizado, debe autenticarse";
		mv.addObject("errorMsg", errorMessage);
		mv.setViewName("login");
		return mv;
	}
	@GetMapping("/home")
	public ModelAndView home() {
		org.springframework.web.servlet.ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
}
