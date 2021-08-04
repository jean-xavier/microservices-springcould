package br.com.microservice.fornecedor.fornecedor.service.impl;

import br.com.microservice.fornecedor.fornecedor.controller.dto.ItemDoPedido;
import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import br.com.microservice.fornecedor.fornecedor.model.PedidoItem;
import br.com.microservice.fornecedor.fornecedor.model.Produto;
import br.com.microservice.fornecedor.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.fornecedor.repository.ProdutoRepository;
import br.com.microservice.fornecedor.fornecedor.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Pedido realizaPedido(List<ItemDoPedido> itens) {

        if(itens == null) {
            return null;
        }

        List<PedidoItem> pedidoItens = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoItens);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedido> itens) {

        List<Long> idsProdutos = itens.stream().map(ItemDoPedido::getId).collect(Collectors.toList());

        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

        return itens.stream().map(item -> {
                    Produto produto = produtosDoPedido
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    PedidoItem pedidoItem = new PedidoItem();
                    pedidoItem.setProduto(produto);
                    pedidoItem.setQuantidade(item.getQuantidade());
                    return pedidoItem;
                }).collect(Collectors.toList());
    }
}
