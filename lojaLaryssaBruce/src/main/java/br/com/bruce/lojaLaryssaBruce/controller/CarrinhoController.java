package br.com.bruce.lojaLaryssaBruce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.bruce.lojaLaryssaBruce.modelo.Cliente;
import br.com.bruce.lojaLaryssaBruce.modelo.Compra;
import br.com.bruce.lojaLaryssaBruce.modelo.ItensCompra;
import br.com.bruce.lojaLaryssaBruce.modelo.Produto;
import br.com.bruce.lojaLaryssaBruce.repositorio.ProdutoRepositorio;
import br.com.bruce.lojaLaryssaBruce.service.CarrinhoService;
import br.com.bruce.lojaLaryssaBruce.service.ProdutoService;

@Controller
public class CarrinhoController {

	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@GetMapping("/carrinho")
	public ModelAndView carrinho() {
		ModelAndView mav = new ModelAndView("cliente/carrinho");
		Compra compra = this.carrinhoService.calcularTotal();
		mav.addObject("compra", compra);
		List<ItensCompra> itensCompra = this.carrinhoService.itensCompra();
		mav.addObject("listaItens", itensCompra);
		List<Produto> produto = this.produtoRepositorio.findAll();
		mav.addObject("produto", produto);
		return mav;
	}

	@GetMapping("/finalizar")
	public ModelAndView finalizarCompra() {
//		this.carrinhoService.buscarUsuarioLogado();
		ModelAndView mav = new ModelAndView("cliente/finalizar");
		Compra compra = this.carrinhoService.calcularTotal();
		mav.addObject("compra", compra);
		List<ItensCompra> itensCompra = this.carrinhoService.itensCompra();
		mav.addObject("itensLista", itensCompra);
		Cliente cliente = this.carrinhoService.getCliente();
		mav.addObject("cliente", cliente);
		return mav;
	}

	@PostMapping("/finalizar/confirmar")
	public ModelAndView confirmarCompra(String formaPagamento) {
		ModelAndView mav = new ModelAndView("cliente/mensagemFinalizou");
		this.carrinhoService.confirmarCompra(formaPagamento);
		return mav;
	}

	@GetMapping("/alterarQuantidade/{id}/{acao}")
	public String alterarQuantidade(@PathVariable Long id, @PathVariable Integer acao) {
		String redirect = this.carrinhoService.alterarQuantidade(id, acao);
		return redirect;
	}

	@GetMapping("/removerProduto/{id}")
	public String removerProdutoCarrinho(@PathVariable Long id) {
		String redirect = this.carrinhoService.removerProdutoCarrinho(id);
		return redirect;
	}

	@GetMapping("/adicionarCarrinho/{id}")
	public String adicioneCarrinho(@PathVariable Long id) {
		String redirect = this.carrinhoService.adicioneCarrinho(id);		
		return redirect;
	}
	
	@GetMapping("/produtoDetalhe/adicionarCarrinho/{id}")
	public String adicioneCarrinhoDetalhe(@PathVariable Long id) {
		this.carrinhoService.adicioneCarrinho(id);		
		return "redirect:/produto/{id}";
	}
	
}
