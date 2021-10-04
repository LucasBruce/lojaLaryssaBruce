package br.com.bruce.lojaLaryssaBruce.service.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.bruce.lojaLaryssaBruce.modelo.Foto;
import br.com.bruce.lojaLaryssaBruce.modelo.Produto;
import br.com.bruce.lojaLaryssaBruce.repositorio.FotoRepositorio;
import br.com.bruce.lojaLaryssaBruce.repositorio.ProdutoRepositorio;
import br.com.bruce.lojaLaryssaBruce.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private static String caminhoImagem = "C:\\Users\\lucas.matheus\\Pictures";

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Autowired
	private FotoRepositorio fotoRepositorio;

	@Override
	public byte[] findByImage(String imagem) throws IOException{
     File caminhoArquivo = new File(caminhoImagem+imagem);
     
     if(imagem!=null || imagem.trim().length()>0) {
    	 return Files.readAllBytes(caminhoArquivo.toPath());
     }
		return null;
	}

	@Override
	public void save(Produto produto, MultipartFile arquivo) {



	}
	
	@Override
	public List<Produto> findAll(){
		return this.produtoRepositorio.findAll();
	}
	
	@Override
	public void delete(long id) {
		Optional<Produto> produto = this.produtoRepositorio.findById(id);
		this.produtoRepositorio.delete(produto.get());
	}
	
	@Override
	public Produto findById(long id) {
		 Optional<Produto> produto = this.produtoRepositorio.findById(id);
		return produto.get();
	}

}
