package br.com.bruce.lojaLaryssaBruce.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.bruce.lojaLaryssaBruce.modelo.Produto;

public interface ProdutoService {

	byte[] findByImage(String imagem) throws IOException;

	void save(Produto produto, MultipartFile arquivo1, MultipartFile arquivo2, MultipartFile arquivo3,
			MultipartFile arquivo4, MultipartFile arquivo5, MultipartFile arquivo6, MultipartFile arquivo7);

	List<Produto> findAll();

	void delete(long id);
	
	Produto findById(long id);
	
	//Melhore o código que salva a imagem
	//Passe todas as funcões para o pacote service
}
