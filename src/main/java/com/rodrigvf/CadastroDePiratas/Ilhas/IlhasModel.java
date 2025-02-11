package com.rodrigvf.CadastroDePiratas.Ilhas;

import com.rodrigvf.CadastroDePiratas.Piratas.PirataModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_ilhas")
public class IlhasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String regiao;

    @OneToMany(mappedBy = "ilhas")
    private List<PirataModel> piratas;

    public IlhasModel() {
    }

    public IlhasModel(String nome, String regiao) {
        this.nome = nome;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
