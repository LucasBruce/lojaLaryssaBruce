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

import br.com.bruce.lojaLaryssaBruce.modelo.Produto;
import br.com.bruce.lojaLaryssaBruce.repositorio.ProdutoRepositorio;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@GetMapping("/gerencia/produto/cadastro")
	public ModelAndView cadastro(Produto produto) {
		ModelAndView mav = new ModelAndView("/gerencia/produto/cadastro");
		mav.addObject("produto", produto);
		return mav;
	}
	
	@GetMapping("/gerencia/produto/lista")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView("/gerencia/produto/lista");
		mav.addObject("listaProduto", this.produtoRepositorio.findAll());
		return mav;
	}
	
	@PostMapping("/gerencia/produto/salvar")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result) {
		if(result.hasErrors()) {
			return cadastro(produto);
		}
		this.produtoRepositorio.saveAndFlush(produto);
		return cadastro(new Produto());
	}
	
	@GetMapping("/gerencia/produto/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Produto> produto = this.produtoRepositorio.findById(id);
		this.produtoRepositorio.delete(produto.get());
		return lista();
	}
	
	@GetMapping("/gerencia/produto/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Produto> produto = this.produtoRepositorio.findById(id);
		return cadastro(produto.get());
	}
}
