package br.com.bruce.lojaLaryssaBruce.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bruce.lojaLaryssaBruce.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

	@Query("from Cliente where email=?1")
	public List<Cliente> buscarClienteEmail(String email);
}
