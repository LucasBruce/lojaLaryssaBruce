package br.com.bruce.lojaLaryssaBruce.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruce.lojaLaryssaBruce.modelo.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
