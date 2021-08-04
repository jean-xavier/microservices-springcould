package br.com.microservice.fornecedor.fornecedor.service.impl;

import br.com.microservice.fornecedor.fornecedor.model.InfoFornecedor;
import br.com.microservice.fornecedor.fornecedor.repository.InfoRepository;
import br.com.microservice.fornecedor.fornecedor.service.InfoService;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    private final InfoRepository infoRepository;

    public InfoServiceImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    public InfoFornecedor getInfoPorEstado(String estado) {
        return infoRepository.findByEstado(estado).orElseThrow(() -> new RuntimeException("Deu ruim"));
    }
}
