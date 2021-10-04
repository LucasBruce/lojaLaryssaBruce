package br.com.bruce.lojaLaryssaBruce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FotoController {

	@GetMapping("/gerencia/produto/foto")
	public ModelAndView getFoto() {
		ModelAndView mav = new ModelAndView("/gerencia/produto/foto");
		return mav;
	}
}
