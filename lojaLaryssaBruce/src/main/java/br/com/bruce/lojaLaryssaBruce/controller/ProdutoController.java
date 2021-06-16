package br.com.bruce.lojaLaryssaBruce.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

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
import br.com.bruce.lojaLaryssaBruce.repositorio.ProdutoRepositorio;
import br.com.bruce.lojaLaryssaBruce.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

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
		mav.addObject("listaProdutos", this.produtoRepositorio.findAll());
		return mav;
	}
	
	@GetMapping("/gerencia/produto/retornarImagem/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem") String imagem) throws IOException{		
		return this.produtoService.findByImage(imagem);
	}

	@PostMapping("/gerencia/produto/salvar")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result,
			@RequestParam("file1") MultipartFile arquivo1, @RequestParam("file2") MultipartFile arquivo2,
			@RequestParam("file3") MultipartFile arquivo3, @RequestParam("file4") MultipartFile arquivo4,
			@RequestParam("file5") MultipartFile arquivo5) {
		
		if (result.hasErrors()) {
			return cadastro(produto);
		}
		this.produtoService.save(produto, arquivo1, arquivo2, arquivo3, arquivo4, arquivo5);
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
