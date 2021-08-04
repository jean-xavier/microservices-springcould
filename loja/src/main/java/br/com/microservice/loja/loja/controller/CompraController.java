package br.com.microservice.loja.loja.controller;

import br.com.microservice.loja.loja.controller.dto.CompraRequest;
import br.com.microservice.loja.loja.model.Compra;
import br.com.microservice.loja.loja.service.CompraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/compra")
    public Compra comprar(@RequestBody CompraRequest request) {
        return compraService.realizarCompra(request);
    }
}
