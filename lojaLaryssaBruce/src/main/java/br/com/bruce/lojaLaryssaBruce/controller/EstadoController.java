package br.com.bruce.lojaLaryssaBruce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import br.com.bruce.lojaLaryssaBruce.modelo.Estado;
import br.com.bruce.lojaLaryssaBruce.repositorio.EstadoRepositorio;

@Controller
public class EstadoController {
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@GetMapping("/gerencia")
	public ModelAndView cadastrar(Estado estado) {
		ModelAndView mav = new ModelAndView("/gerencia/estado/cadastrar");
		mav.addObject("estado", estado);
		return mav;
	}
	
	
}
