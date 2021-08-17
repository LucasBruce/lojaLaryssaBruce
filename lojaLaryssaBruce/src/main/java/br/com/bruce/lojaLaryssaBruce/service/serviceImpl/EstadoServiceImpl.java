package br.com.bruce.lojaLaryssaBruce.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruce.lojaLaryssaBruce.modelo.Estado;
import br.com.bruce.lojaLaryssaBruce.repositorio.EstadoRepositorio;
import br.com.bruce.lojaLaryssaBruce.service.EstadoService;
@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepositorio estadoRepositorio;

	@Override
	public List<Estado> findAll() {
		return this.estadoRepositorio.findAll();
	}

	@Override
	public void save(Estado estado) {
		this.estadoRepositorio.saveAndFlush(estado);

	}

	@Override
	public Estado findById(long id) {
		Optional<Estado> estado = this.estadoRepositorio.findById(id);
		return estado.get();
	}

	@Override
	public void delete(long id) {
		Optional<Estado> estado = this.estadoRepositorio.findById(id);
		this.estadoRepositorio.delete(estado.get());

	}

}
