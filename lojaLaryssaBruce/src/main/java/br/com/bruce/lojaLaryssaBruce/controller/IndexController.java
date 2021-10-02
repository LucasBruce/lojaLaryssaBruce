package br.com.bruce.lojaLaryssaBruce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.bruce.lojaLaryssaBruce.modelo.ItensCompra;
import br.com.bruce.lojaLaryssaBruce.modelo.Produto;
import br.com.bruce.lojaLaryssaBruce.service.CarrinhoService;
import br.com.bruce.lojaLaryssaBruce.service.ProdutoService;

@Controller
public class IndexController {

@Autowired
private ProdutoService produtoService;

@Autowired
private CarrinhoService carrinhoService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		List<Produto> produto = this.produtoService.findAll();
		mav.addObject("listaProdutos", produto);
		List<ItensCompra> itensCompra = this.carrinhoService.itensCompra();
		mav.addObject("itensCompra", itensCompra);
		return mav;
	}
	
	@GetMapping("/produto/{id}")
	public ModelAndView getDetailsProduto(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("produtoDetalhe");
		Produto produto = this.produtoService.findById(id);
		mav.addObject("produto",produto);
		List<ItensCompra> itensCompra = this.carrinhoService.itensCompra();
		mav.addObject("itensCompra", itensCompra);
		return mav;
	}
}
