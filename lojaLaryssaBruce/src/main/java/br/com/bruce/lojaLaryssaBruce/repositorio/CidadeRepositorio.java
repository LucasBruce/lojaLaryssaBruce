package br.com.bruce.lojaLaryssaBruce.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruce.lojaLaryssaBruce.modelo.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Long>{

}
