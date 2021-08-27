package br.com.bruce.lojaLaryssaBruce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarrinhoController {
	
	@GetMapping("/carrinho")
	public ModelAndView carrinho() {
		ModelAndView mav = new ModelAndView("cliente/carrinho");
		return mav;
	}

}
