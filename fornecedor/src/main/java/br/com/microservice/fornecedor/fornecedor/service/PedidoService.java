package br.com.microservice.fornecedor.fornecedor.service;

import br.com.microservice.fornecedor.fornecedor.controller.dto.ItemDoPedido;
import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoService {
    Pedido realizaPedido(List<ItemDoPedido> produtos);
    Pedido getPedidoPorId(Long id);
}
