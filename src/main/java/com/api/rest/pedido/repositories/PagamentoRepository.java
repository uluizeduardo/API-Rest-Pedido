package com.api.rest.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.pedido.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
