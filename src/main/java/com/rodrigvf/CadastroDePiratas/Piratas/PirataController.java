package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PirataController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Bem vindo(a) à API de cadastro Pirata";
    }

    // Adicionar (CREATE)
    @PostMapping("/criar")
    public String criarPirata() {
        return "Pirata criado com sucesso!";
    }

    // Mostrar todos os piratas (READ)
    @GetMapping("/all")
    public String mostrarTodosPiratas() {
        return "Mostrar pirata!";
    }

    // Procurar Pirata por ID (READ)
    @GetMapping("/allID")
    public String mostrarPirataId() {
        return "Mostrar pirata por ID!";
    }

    // Alterar dados dos piratas (UPDATE
    @PutMapping("/alterarID")
    public String alterarPirataId() {
        return "Pirata atualizado com sucesso!";
    }

    // Deletar Pirata (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarPirataId() {
        return "Pirata deletado com sucesso!";
    }
}
