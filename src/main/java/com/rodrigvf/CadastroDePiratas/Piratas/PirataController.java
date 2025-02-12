package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piratas")
public class PirataController {

    private PirataService pirataService;

    public PirataController(PirataService pirataService) {
        this.pirataService = pirataService;
    }

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
    @GetMapping("/listar")
    public List<PirataModel> listarPiratas() {
        return pirataService.listarPiratas();
    }

    // Procurar Pirata por ID (READ)
    @GetMapping("/listarID")
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
