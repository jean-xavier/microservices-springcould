package br.com.microservice.fornecedor.fornecedor.service.impl;

import br.com.microservice.fornecedor.fornecedor.model.Produto;
import br.com.microservice.fornecedor.fornecedor.repository.ProdutoRepository;
import br.com.microservice.fornecedor.fornecedor.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> getProdutosPorEstado(String estado) {
        return produtoRepository.findByEstado(estado);
    }
}
