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
    public PirataDTO criarPirata(@RequestBody PirataDTO pirata) {
        return pirataService.criarPirata(pirata);
    }

    // Mostrar todos os piratas (READ)
    @GetMapping("/listar")
    public List<PirataDTO> listarPiratas() {
        return pirataService.listarPiratas();
    }

    // Procurar Pirata por ID (READ)
    @GetMapping("/listar/{id}")
    public PirataDTO buscarPirataPorId(@PathVariable Long id) {
        return pirataService.buscarPirataPorId(id);
    }

    // Alterar dados dos piratas (UPDATE
    @PutMapping("/alterar/{id}")
    public PirataDTO alterarPirata(@PathVariable Long id, @RequestBody PirataDTO pirataAtualizado) {
        return pirataService.alterarPirata(id, pirataAtualizado);
    }

    // Deletar Pirata (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarPirataPorId(@PathVariable Long id) {
        pirataService.deletarPirataPorId(id);
    }
}
