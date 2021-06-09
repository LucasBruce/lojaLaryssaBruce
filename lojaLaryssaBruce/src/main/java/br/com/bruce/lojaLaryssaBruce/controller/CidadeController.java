package br.com.bruce.lojaLaryssaBruce.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import br.com.bruce.lojaLaryssaBruce.modelo.Cidade;
import br.com.bruce.lojaLaryssaBruce.repositorio.CidadeRepositorio;
import br.com.bruce.lojaLaryssaBruce.repositorio.EstadoRepositorio;

@Controller
public class CidadeController {

	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;

	@GetMapping("/gerencia/cidade/cadastro")
	public ModelAndView cadastro(Cidade cidade) {
		ModelAndView mav = new ModelAndView("/gerencia/cidade/cadastro");
		mav.addObject("cidade", cidade);
		mav.addObject("listaEstados", this.estadoRepositorio.findAll());
		return mav;
	}
	
	@GetMapping("/gerencia/cidade/lista")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("/gerencia/cidade/lista");
		mav.addObject("listaCidade", this.cidadeRepositorio.findAll());
		return mav;
	}
	
	@PostMapping("/gerencia/cidade/salvar")
	public ModelAndView salvar(@Valid Cidade cidade, BindingResult result) {
		if(result.hasErrors()) {
			return cadastro(cidade);
		}
		this.cidadeRepositorio.saveAndFlush(cidade);
		return cadastro(new Cidade());
	}
	
	@GetMapping("/gerencia/cidade/remover/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Cidade> cidade = this.cidadeRepositorio.findById(id);
		this.cidadeRepositorio.delete(cidade.get());
		return listar();
	}
	
	@GetMapping("/gerencia/cidade/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Cidade> cidade = this.cidadeRepositorio.findById(id);
		return cadastro(cidade.get());
	}
}
