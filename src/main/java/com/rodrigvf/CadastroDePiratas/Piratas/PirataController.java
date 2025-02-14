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
    public PirataModel criarPirata(@RequestBody PirataModel pirata) {
        return pirataService.criarPirata(pirata);
    }

    // Mostrar todos os piratas (READ)
    @GetMapping("/listar")
    public List<PirataModel> listarPiratas() {
        return pirataService.listarPiratas();
    }

    // Procurar Pirata por ID (READ)
    @GetMapping("/listar/{id}")
    public PirataModel buscarPirataPorId(@PathVariable Long id) {
        return pirataService.buscarPirataPorId(id);
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
