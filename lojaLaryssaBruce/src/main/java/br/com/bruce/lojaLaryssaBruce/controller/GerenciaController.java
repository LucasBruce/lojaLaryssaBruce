package br.com.bruce.lojaLaryssaBruce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GerenciaController {
	
	@GetMapping("/gerencia")
	public String gerencia() {
		return "index";
	}

}
