package com.rodrigvf.CadastroDePiratas.Piratas;

import com.rodrigvf.CadastroDePiratas.Ilhas.IlhaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PirataDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private BigDecimal recompensa;
    private IlhaModel ilhas;

}
