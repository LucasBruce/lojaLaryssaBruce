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
	public void save(Produto produto, MultipartFile arquivo1, MultipartFile arquivo2, MultipartFile arquivo3,
			MultipartFile arquivo4, MultipartFile arquivo5, MultipartFile arquivo6) {

		try {
			Foto foto = new Foto();
			Random random = new Random();
			if (!arquivo1.isEmpty()) {
				int numero1 = random.nextInt(50000);
				byte[] bytes1 = arquivo1.getBytes();
				Path caminho1 = Paths.get(caminhoImagem + String.valueOf(numero1 + arquivo1.getOriginalFilename()));
				Files.write(caminho1, bytes1);
				foto.setNomeFoto1(String.valueOf(numero1 + arquivo1.getOriginalFilename()));

			}
			if (!arquivo2.isEmpty()) {
				int numero2 = random.nextInt(50000);
				byte[] bytes2 = arquivo2.getBytes();
				Path caminho2 = Paths.get(caminhoImagem + String.valueOf(numero2 + arquivo2.getOriginalFilename()));
				Files.write(caminho2, bytes2);
				foto.setNomeFoto2(String.valueOf(numero2 + arquivo2.getOriginalFilename()));

			}
			if (!arquivo3.isEmpty()) {
				int numero3 = random.nextInt(50000);
				byte[] bytes3 = arquivo3.getBytes();
				Path caminho3 = Paths.get(caminhoImagem + String.valueOf(numero3 + arquivo3.getOriginalFilename()));
				Files.write(caminho3, bytes3);
				foto.setNomeFoto3(String.valueOf(numero3 + arquivo3.getOriginalFilename()));
			}
			if (!arquivo4.isEmpty()) {
				int numero4 = random.nextInt(50000);
				byte[] bytes4 = arquivo4.getBytes();
				Path caminho4 = Paths.get(caminhoImagem + String.valueOf(numero4 + arquivo4.getOriginalFilename()));
				Files.write(caminho4, bytes4);
				foto.setNomeFoto4(String.valueOf(numero4 + arquivo4.getOriginalFilename()));
			}
			if (!arquivo5.isEmpty()) {
				int numero5 = random.nextInt(50000);
				byte[] bytes5 = arquivo5.getBytes();
				Path caminho5 = Paths.get(caminhoImagem + String.valueOf(numero5 + arquivo5.getOriginalFilename()));
				Files.write(caminho5, bytes5);
				foto.setNomeFoto5(String.valueOf(numero5 + arquivo5.getOriginalFilename()));
			}
			if (!arquivo6.isEmpty()) {
				int numero6 = random.nextInt(50000);
				byte[] bytes6 = arquivo6.getBytes();
				Path caminho6 = Paths.get(caminhoImagem + String.valueOf(numero6 + arquivo6.getOriginalFilename()));
				Files.write(caminho6, bytes6);
				foto.setNomeFoto6(String.valueOf(numero6 + arquivo6.getOriginalFilename()));
			}

			this.fotoRepositorio.saveAndFlush(foto);
			produto.setFoto(foto);
			this.produtoRepositorio.saveAndFlush(produto);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
