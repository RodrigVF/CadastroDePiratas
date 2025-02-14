package com.rodrigvf.CadastroDePiratas.Piratas;

import com.rodrigvf.CadastroDePiratas.Ilhas.IlhaModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PirataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column (name = "recompensa")
    private double recompensa;

    @ManyToOne
    @JoinColumn(name = "ilhas_id")
    private IlhaModel ilhas;

}
