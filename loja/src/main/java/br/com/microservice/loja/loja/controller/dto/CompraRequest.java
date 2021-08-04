package br.com.microservice.loja.loja.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class CompraRequest {
    private List<ItensCompraRequest> itens = new ArrayList<>();
    private EnderecoRequest endereco;

    public List<ItensCompraRequest> getItens() {
        return itens;
    }

    public void setItens(List<ItensCompraRequest> itens) {
        this.itens = itens;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequest endereco) {
        this.endereco = endereco;
    }
}
