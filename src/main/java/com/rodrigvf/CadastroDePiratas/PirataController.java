package com.rodrigvf.CadastroDePiratas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PirataController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Bem vindo(a) à API de cadastro Pirata";
    }



}
