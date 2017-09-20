package br.com.systemplus.simulatorapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produto_estoque")
public class ProdutoEstoque extends BaseEntity<ProdutoEstoque> {

    private int quantia;

    public int getQuantia() {
        return quantia;
    }

    public void setQuantia(int quantia) {
        this.quantia = quantia;
    }

    @Override
    public void updateBasedOn(ProdutoEstoque target) {

    }
}
