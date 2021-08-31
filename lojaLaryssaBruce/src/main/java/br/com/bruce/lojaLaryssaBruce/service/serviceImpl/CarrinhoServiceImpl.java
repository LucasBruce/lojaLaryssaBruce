package br.com.bruce.lojaLaryssaBruce.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruce.lojaLaryssaBruce.modelo.Cliente;
import br.com.bruce.lojaLaryssaBruce.modelo.Compra;
import br.com.bruce.lojaLaryssaBruce.modelo.ItensCompra;
import br.com.bruce.lojaLaryssaBruce.repositorio.ClienteRepositorio;
import br.com.bruce.lojaLaryssaBruce.repositorio.CompraRepositorio;
import br.com.bruce.lojaLaryssaBruce.repositorio.ItensCompraRepositorio;
import br.com.bruce.lojaLaryssaBruce.repositorio.ProdutoRepositorio;
import br.com.bruce.lojaLaryssaBruce.service.CarrinhoService;
import br.com.bruce.lojaLaryssaBruce.modelo.Produto;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
	private Compra compra = new Compra();
	private Cliente cliente;
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private CompraRepositorio compraRepositorio;

	@Autowired
	private ItensCompraRepositorio itensCompraRepositorio;

	@Override
	public void calcularTotal() {
		compra.setValorTotal(0.);
		for (ItensCompra it : itensCompra) {
			compra.setValorTotal(compra.getValorTotal() + it.getValorTotal());
		}

	}

//	@Override
//	public void buscarUsuarioLogado() {
//		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
//		if (!(autenticado instanceof AnonymousAuthenticationToken)) {
//			String email = autenticado.getName();
//			cliente = this.clienteRepositorio.buscarClienteEmail(email).get(0);
//		}
//
//	}

	@Override
	public void confirmarCompra(String formaPagamento) {
		this.compra.setCliente(cliente);
		this.compra.setFormaPagamento(formaPagamento);
		this.compraRepositorio.saveAndFlush(compra);

		for (ItensCompra c : itensCompra) {
			c.setCompra(compra);
			this.itensCompraRepositorio.saveAndFlush(c);
		}
		itensCompra = new ArrayList<>();
		compra = new Compra();
	}

	@Override
	public String alterarQuantidade(Long id, Integer acao) {
		for (ItensCompra it : itensCompra) {
			if (it.getProduto().getId().equals(id)) {
				// System.out.println(it.getValorTotal());
				if (acao.equals(1)) {
					it.setQuantidade(it.getQuantidade() + 1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
				} else if (acao == 0) {
					if (it.getQuantidade() != (0))
						it.setQuantidade(it.getQuantidade() - 1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
				}
				break;

			}
		}
		return "redirect:/carrinho";
	}

	@Override
	public String removerProdutoCarrinho(Long id) {
		for (ItensCompra it : itensCompra) {
			if (it.getProduto().getId().equals(id)) {
				itensCompra.remove(it);
				break;

			}
		}
		return "redirect:/carrinho";
	}

	@Override
	public void adicioneCarrinho(Long id) {
		Optional<Produto> prod = produtoRepositorio.findById(id);
		Produto produto = prod.get();
		int controle = 0;
		for (ItensCompra it : itensCompra) {
			if (it.getProduto().getId().equals(produto.getId())) {
				it.setQuantidade(it.getQuantidade() + 1);
				it.setValorTotal(0.);
				it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
				controle = 1;
				break;
			}
		}
		if (controle == 0) {
			ItensCompra item = new ItensCompra();
			item.setProduto(produto);
			item.setValorUnitario(produto.getValorVenda());
			item.setQuantidade(item.getQuantidade() + 1);
			item.setValorTotal(item.getValorTotal() + (item.getQuantidade() * item.getValorUnitario()));

			itensCompra.add(item);
		}		
	}

	@Override
	public List<ItensCompra> itensCompra() {		
		return itensCompra;
	}

}
