package br.com.microservice.fornecedor.fornecedor.controller;

import java.util.List;

import br.com.microservice.fornecedor.fornecedor.controller.dto.ItemDoPedido;
import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import br.com.microservice.fornecedor.fornecedor.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido realizaPedido(@RequestBody List<ItemDoPedido> produtos) {
        LOG.info("pedido recebido");
        return pedidoService.realizaPedido(produtos);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}
