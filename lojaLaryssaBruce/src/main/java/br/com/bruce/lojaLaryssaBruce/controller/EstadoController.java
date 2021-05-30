package br.com.bruce.lojaLaryssaBruce.controller;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bruce.lojaLaryssaBruce.modelo.Estado;
import br.com.bruce.lojaLaryssaBruce.repositorio.EstadoRepositorio;

@Controller
public class EstadoController {
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@GetMapping("/gerencia")
	public String cadastrar() {
		
		return "/gerencia/estado/cadastro";
	}
	
	@GetMapping("/gerencia/estado/cadastro")
	public  ModelAndView cadastro(Estado estado) {
		ModelAndView mav = new ModelAndView("/gerencia/estado/cadastro");
    	mav.addObject("estado", estado);
    	return mav;
	}
	
	@PostMapping("gerencia/estado/salvar")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result) {
		if(result.hasErrors()) {
			return cadastro(estado);
		}
		this.estadoRepositorio.saveAndFlush(estado);
		return cadastro(new Estado());
	}
	
	
}
