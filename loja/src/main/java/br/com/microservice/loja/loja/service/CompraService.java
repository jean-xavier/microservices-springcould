package br.com.microservice.loja.loja.service;

import br.com.microservice.loja.loja.controller.dto.CompraRequest;
import br.com.microservice.loja.loja.model.Compra;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {
    Compra realizarCompra(CompraRequest request);
}
