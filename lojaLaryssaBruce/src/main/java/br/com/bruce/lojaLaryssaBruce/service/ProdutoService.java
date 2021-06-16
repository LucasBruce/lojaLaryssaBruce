package br.com.bruce.lojaLaryssaBruce.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import br.com.bruce.lojaLaryssaBruce.modelo.Produto;

public interface ProdutoService {

	byte[] findByImage(String imagem) throws IOException;

	void save(Produto produto, MultipartFile arquivo1, MultipartFile arquivo2, MultipartFile arquivo3,
			MultipartFile arquivo4, MultipartFile arquivo5);
}
