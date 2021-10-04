package br.com.bruce.lojaLaryssaBruce.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import br.com.bruce.lojaLaryssaBruce.modelo.Cidade;
import br.com.bruce.lojaLaryssaBruce.modelo.Estado;
import br.com.bruce.lojaLaryssaBruce.service.CidadeService;
import br.com.bruce.lojaLaryssaBruce.service.EstadoService;

@Controller
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	@GetMapping("/gerencia/cidade/cadastro")
	public ModelAndView cadastro(Cidade cidade) {
		ModelAndView mav = new ModelAndView("/gerencia/cidade/cadastro");
		mav.addObject("cidade", cidade);
		List<Estado> estado = this.estadoService.findAll();
		mav.addObject("listaEstados", estado);
		return mav;
	}

	@GetMapping("/gerencia/cidade/lista")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("/gerencia/cidade/lista");
		List<Cidade> cidade = this.cidadeService.findAll();
		mav.addObject("listaCidade", cidade);
		return mav;
	}

	@PostMapping("/gerencia/cidade/salvar")
	public ModelAndView salvar(@Valid Cidade cidade, BindingResult result) {
		if (result.hasErrors()) {
			return cadastro(cidade);
		}
		this.cidadeService.save(cidade);
		return cadastro(new Cidade());
	}

	@GetMapping("/gerencia/cidade/remover/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		this.cidadeService.delete(id);
		return listar();
	}

	@GetMapping("/gerencia/cidade/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Cidade cidade = this.cidadeService.findById(id);
		return cadastro(cidade);
	}
}
