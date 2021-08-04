package br.com.microservice.fornecedor.fornecedor.controller;

import br.com.microservice.fornecedor.fornecedor.model.InfoFornecedor;
import br.com.microservice.fornecedor.fornecedor.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/{estado}")
    public InfoFornecedor inforEstado(@PathVariable String estado) {
        LOG.info("recebido o pedido de informações do fornecedor de {}", estado);
        return infoService.getInfoPorEstado(estado);
    }

}
