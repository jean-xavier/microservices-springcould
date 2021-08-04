package br.com.microservice.fornecedor.fornecedor.service;

import br.com.microservice.fornecedor.fornecedor.model.InfoFornecedor;
import org.springframework.stereotype.Service;

@Service
public interface InfoService {
    InfoFornecedor getInfoPorEstado(String estado);
}
