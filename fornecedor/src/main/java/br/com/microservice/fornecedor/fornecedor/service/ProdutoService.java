package br.com.microservice.fornecedor.fornecedor.service;

import br.com.microservice.fornecedor.fornecedor.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {
    List<Produto> getProdutosPorEstado(String estado);
}
