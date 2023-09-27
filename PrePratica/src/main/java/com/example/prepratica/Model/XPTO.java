package com.example.prepratica.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class XPTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Column(name = "descricao")
    private String desc;
    private double preco;
    @Column(name = "quantidadeestoque")
    private int qntEstroque;

    public XPTO(long id, String nome, String desc, double preco, int qntEstroque) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.qntEstroque = qntEstroque;
    }

    public XPTO(String nome, String desc, double preco, int qntEstroque) {
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.qntEstroque = qntEstroque;
    }
    public XPTO(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntEstroque() {
        return qntEstroque;
    }

    public void setQntEstroque(int qntEstroque) {
        this.qntEstroque = qntEstroque;
    }



    @Override
    public String toString() {
        return "XPTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                ", preco=" + preco +
                ", qntEstroque=" + qntEstroque +
                '}' ;
    }
}
