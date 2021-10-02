package br.com.bruce.lojaLaryssaBruce.service;

import java.util.List;

import br.com.bruce.lojaLaryssaBruce.modelo.Cliente;
import br.com.bruce.lojaLaryssaBruce.modelo.Compra;
import br.com.bruce.lojaLaryssaBruce.modelo.ItensCompra;

public interface CarrinhoService {
	
	List<ItensCompra> itensCompra();
	
	Cliente getCliente();

	Compra calcularTotal();

//	void buscarUsuarioLogado();

	void confirmarCompra(String formaPagamento);

	String alterarQuantidade(Long id, Integer acao);

	String removerProdutoCarrinho(Long id);

	String adicioneCarrinho(Long id);

}
