package com.api.rest.pedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.repositories.CategoriaRepository;

@SpringBootApplication
public class ApiRestPedidoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Escritório");
		Categoria categoria2 = new Categoria(null, "Informática");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
	}

}
