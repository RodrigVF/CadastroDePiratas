package com.rodrigvf.CadastroDePiratas.Piratas;

import com.rodrigvf.CadastroDePiratas.Ilhas.IlhasModel;
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
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "ilhas_id")
    private IlhasModel ilhas;

}
