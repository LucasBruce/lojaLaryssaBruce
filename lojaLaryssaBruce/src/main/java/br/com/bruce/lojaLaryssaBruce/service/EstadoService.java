package br.com.bruce.lojaLaryssaBruce.service;

import java.util.List;

import br.com.bruce.lojaLaryssaBruce.modelo.Estado;

public interface EstadoService {

	List<Estado> findAll();

	void save(Estado estado);

	Estado findById(long id);

	void delete(long id);
}
