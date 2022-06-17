package com.api.rest.pedido;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.rest.pedido.enums.EstadoPagamento;
import com.api.rest.pedido.enums.TipoCliente;
import com.api.rest.pedido.model.Categoria;
import com.api.rest.pedido.model.Cidade;
import com.api.rest.pedido.model.Cliente;
import com.api.rest.pedido.model.Endereco;
import com.api.rest.pedido.model.Estado;
import com.api.rest.pedido.model.Pagamento;
import com.api.rest.pedido.model.PagamentoComBoleto;
import com.api.rest.pedido.model.PagamentoComCartao;
import com.api.rest.pedido.model.Pedido;
import com.api.rest.pedido.model.Produto;
import com.api.rest.pedido.repositories.CategoriaRepository;
import com.api.rest.pedido.repositories.CidadeRepository;
import com.api.rest.pedido.repositories.ClienteRepository;
import com.api.rest.pedido.repositories.EnderecoRepository;
import com.api.rest.pedido.repositories.EstadoRepository;
import com.api.rest.pedido.repositories.PagamentoRepository;
import com.api.rest.pedido.repositories.PedidoRepository;
import com.api.rest.pedido.repositories.ProdutoRepository;

@SpringBootApplication
public class ApiRestPedidoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null, "Escritório");
		Categoria categoria2 = new Categoria(null, "Informática");

		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");

		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);

		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "jardim", "38220834", cliente1,
				cidade1);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente1,
				cidade2);

		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));

		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido pedido1 = new Pedido(null, formato.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, formato.parse("10/10/2017 19:35"), cliente1, endereco2);

		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		 
		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, formato.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);
		 
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));
		 
	}

}
