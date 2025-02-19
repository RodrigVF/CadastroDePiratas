package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piratas")
public class PirataController {

    private final PirataService pirataService;

    public PirataController(PirataService pirataService) {
        this.pirataService = pirataService;
    }

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Bem vindo(a) à API de cadastro Pirata";
    }

    // Adicionar (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarPirata(@RequestBody PirataDTO pirata) {

        PirataDTO novoPirata = pirataService.criarPirata(pirata);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Pirata criado com sucesso: " + novoPirata.getNome() + " (ID: " + novoPirata.getId() + ")");

    }

    // Mostrar todos os piratas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<PirataDTO>> listarPiratas() {

        List<PirataDTO> piratas =  pirataService.listarPiratas();
        return ResponseEntity.ok(piratas);

    }

    // Procurar Pirata por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPirataPorId(@PathVariable Long id) {

        PirataDTO pirata = pirataService.buscarPirataPorId(id);

        if ( pirata != null) {
            return ResponseEntity.ok(pirata);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pirata de ID: " + id + " não encontrado!");
        }

    }

    // Alterar dados dos piratas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPirata(@PathVariable Long id, @RequestBody PirataDTO pirataAtualizado) {

        PirataDTO pirata = pirataService.alterarPirata(id, pirataAtualizado);

        if (pirata != null) {
            return ResponseEntity.ok(pirata);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pirata de ID: " + id + " não encontrado!");
        }

    }

    // Deletar Pirata (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPirataPorId(@PathVariable Long id) {

        if (pirataService.buscarPirataPorId(id) != null) {
            pirataService.deletarPirataPorId(id);
            return ResponseEntity.ok("Pirata de ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pirata de ID: " + id + " não encontrado!");
        }

    }
}
