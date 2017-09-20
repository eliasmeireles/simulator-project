package br.com.systemplus.simulatorapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria extends BaseEntity<Categoria> {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void updateBasedOn(Categoria target) {

    }
}
