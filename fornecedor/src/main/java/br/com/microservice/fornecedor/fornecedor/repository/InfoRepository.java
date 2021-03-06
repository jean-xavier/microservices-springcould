package br.com.microservice.fornecedor.fornecedor.repository;

import br.com.microservice.fornecedor.fornecedor.model.InfoFornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
    Optional<InfoFornecedor> findByEstado(String estado);
}
