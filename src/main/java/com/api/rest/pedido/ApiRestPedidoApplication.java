package com.api.rest.pedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.model.Produto;
import com.api.rest.pedido.repositories.CategoriaRepository;
import com.api.rest.pedido.repositories.ProdutoRepository;

@SpringBootApplication
public class ApiRestPedidoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Escritório");
		Categoria categoria2 = new Categoria(null, "Informática");
		
		Produto produto1 = new Produto(null, "Computador" , 2000.00);
		Produto produto2 = new Produto(null, "Impressora" , 800.00);
		Produto produto3 = new Produto(null, "Mouse" , 80.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
	}

}
