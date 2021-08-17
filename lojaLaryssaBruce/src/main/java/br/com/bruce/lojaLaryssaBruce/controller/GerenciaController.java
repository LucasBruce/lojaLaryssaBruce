package br.com.bruce.lojaLaryssaBruce.controller;

 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GerenciaController {
	
	@GetMapping("/gerencia")
	public ModelAndView gerencia() {
		ModelAndView mav = new ModelAndView("gerencia/home");
		return mav;
	}

}
