package br.com.bruce.lojaLaryssaBruce.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruce.lojaLaryssaBruce.modelo.Cidade;
import br.com.bruce.lojaLaryssaBruce.repositorio.CidadeRepositorio;
import br.com.bruce.lojaLaryssaBruce.service.CidadeService;
@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepositorio cidadeRepositorio;

	@Override
	public List<Cidade> findAll() {
		return this.cidadeRepositorio.findAll();
	}

	@Override
	public void save(Cidade cidade) {
		this.cidadeRepositorio.save(cidade);
	}

	@Override
	public Cidade findById(long id) {
		Optional<Cidade> cidade = this.cidadeRepositorio.findById(id);
		return cidade.get();
	}

	@Override
	public void delete(long id) {
		Optional<Cidade> cidade = this.cidadeRepositorio.findById(id);
		this.cidadeRepositorio.delete(cidade.get());
	}

}
