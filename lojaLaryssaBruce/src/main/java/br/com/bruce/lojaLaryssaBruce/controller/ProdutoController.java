package br.com.bruce.lojaLaryssaBruce.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.bruce.lojaLaryssaBruce.modelo.Produto;
import br.com.bruce.lojaLaryssaBruce.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/gerencia/produto/cadastro")
	public ModelAndView cadastro(Produto produto) {
		ModelAndView mav = new ModelAndView("/gerencia/produto/cadastro");
		mav.addObject("produto", produto);
		return mav;
	}

	@GetMapping("/gerencia/produto/lista")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView("/gerencia/produto/lista");
		List<Produto> produto = this.produtoService.findAll();
		mav.addObject("listaProdutos", produto);
		return mav;
	}

	@GetMapping("/gerencia/produto/retornarImagem/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem") String imagem) throws IOException {
		return this.produtoService.findByImage(imagem);
	}

	@PostMapping("/gerencia/produto/salvar")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result,
			@RequestParam("file") MultipartFile arquivo) {

		if (result.hasErrors()) {
			return cadastro(produto);
		}
		this.produtoService.save(produto, arquivo);
		return cadastro(new Produto());
	}

	@GetMapping("/gerencia/produto/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.produtoService.delete(id);
		return lista();
	}

	@GetMapping("/gerencia/produto/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Produto produto = this.produtoService.findById(id);
		return cadastro(produto);
	}
}
