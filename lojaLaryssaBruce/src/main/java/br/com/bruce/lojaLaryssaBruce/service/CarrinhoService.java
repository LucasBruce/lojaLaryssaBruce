package br.com.bruce.lojaLaryssaBruce.service;

import java.util.List;

import br.com.bruce.lojaLaryssaBruce.modelo.ItensCompra;

public interface CarrinhoService {

	void calcularTotal();

//	void buscarUsuarioLogado();

	void confirmarCompra(String formaPagamento);

	String alterarQuantidade(Long id, Integer acao);

	String removerProdutoCarrinho(Long id);

	void adicioneCarrinho(Long id);
	
	List<ItensCompra> itensCompra();
}
