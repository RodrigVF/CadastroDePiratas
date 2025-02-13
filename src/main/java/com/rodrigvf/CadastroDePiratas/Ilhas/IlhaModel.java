package com.rodrigvf.CadastroDePiratas.Ilhas;

import com.rodrigvf.CadastroDePiratas.Piratas.PirataModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "tb_ilhas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IlhaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String regiao;

    @OneToMany(mappedBy = "ilhas")
    private List<PirataModel> piratas;

}
