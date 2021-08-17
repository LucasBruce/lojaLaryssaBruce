package br.com.bruce.lojaLaryssaBruce.service;

import java.util.List;

import br.com.bruce.lojaLaryssaBruce.modelo.Cidade;

public interface CidadeService {

	List<Cidade> findAll();

	void save(Cidade cidade);

	Cidade findById(long id);

	void delete(long id);

}
