package br.com.bruce.lojaLaryssaBruce.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bruce.lojaLaryssaBruce.modelo.Estado;
import br.com.bruce.lojaLaryssaBruce.repositorio.EstadoRepositorio;

@Controller
public class EstadoController {
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	
	@GetMapping("/gerencia/estado/cadastro")
	public  ModelAndView cadastro(Estado estado) {
		ModelAndView mav = new ModelAndView("/gerencia/estado/cadastro");
    	mav.addObject("estado", estado);
    	return mav;
	}
	
	@PostMapping("/gerencia/estado/salvar")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result) {
		if(result.hasErrors()) {
			return cadastro(estado);
		}
		this.estadoRepositorio.saveAndFlush(estado);
		return cadastro(new Estado());
	}
	
	@GetMapping("/gerencia/estado/lista")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView("/gerencia/estado/lista");
	    mav.addObject("listaEstado", this.estadoRepositorio.findAll());
		return mav;
	}
	
	@GetMapping("/gerencia/estado/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Estado> estado = this.estadoRepositorio.findById(id);
		return cadastro(estado.get());
	}
	
	@GetMapping("/gerencia/estado/remover/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Estado> estado = this.estadoRepositorio.findById(id);
		this.estadoRepositorio.delete(estado.get());
		return lista();
	}
	
	
}
