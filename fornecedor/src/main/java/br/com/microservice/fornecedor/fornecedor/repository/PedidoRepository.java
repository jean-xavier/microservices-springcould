package br.com.microservice.fornecedor.fornecedor.repository;

import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
