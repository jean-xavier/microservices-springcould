package br.com.microservice.loja.loja.client;

import br.com.microservice.loja.loja.controller.dto.InfoFornecedorResponse;
import br.com.microservice.loja.loja.controller.dto.InfoPedidoResponse;
import br.com.microservice.loja.loja.controller.dto.ItensCompraRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorResponse getInfoPorEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoResponse realizaPedido(@RequestBody List<ItensCompraRequest> itens);
}
