package br.com.microservice.loja.loja.service.impl;

import br.com.microservice.loja.loja.client.FornecedorClient;
import br.com.microservice.loja.loja.controller.dto.CompraRequest;
import br.com.microservice.loja.loja.controller.dto.InfoFornecedorResponse;
import br.com.microservice.loja.loja.controller.dto.InfoPedidoResponse;
import br.com.microservice.loja.loja.model.Compra;
import br.com.microservice.loja.loja.service.CompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraServiceImpl.class);

    private final FornecedorClient fornecedorClient;

    public CompraServiceImpl(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    @Override
    public Compra realizarCompra(CompraRequest request) {
        LOG.info("buscando informações no fornecedor de {}", request.getEndereco().getEstado());
        InfoFornecedorResponse infoFornecedorResponse  = fornecedorClient.getInfoPorEstado(request.getEndereco().getEstado());

        LOG.info("realizando um pedido");
        InfoPedidoResponse infoPedidoResponse = fornecedorClient.realizaPedido(request.getItens());

        Compra compra = new Compra();
        compra.setEnderecoDestino(infoFornecedorResponse.getEndereco());
        compra.setPedidoId(infoPedidoResponse.getId());
        compra.setTempoDePreparo(infoPedidoResponse.getTempoDePreparo());

        return compra;
    }
}
