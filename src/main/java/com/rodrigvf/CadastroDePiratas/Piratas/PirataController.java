package com.rodrigvf.CadastroDePiratas.Piratas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota retorna mensagem de boas vindas para testar se API está rodando")
    public String boasVindas() {
        return "Bem vindo(a) à API de cadastro Pirata";
    }

    // Adicionar (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Criar um novo pirata", description = "Essa rota é utilizada para criar um novo pirata e inserir no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pirata criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar pirata")
    })

    public ResponseEntity<String> criarPirata(@RequestBody PirataDTO pirata) {

        PirataDTO novoPirata = pirataService.criarPirata(pirata);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Pirata criado com sucesso: " + novoPirata.getNome() + " (ID: " + novoPirata.getId() + ")");

    }

    // Mostrar todos os piratas (READ)
    @GetMapping("/listar")
    @Operation(summary = "Criar um novo pirata", description = "Rota para criar um novo pirata e inserir no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pirata criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar pirata")
    })

    public ResponseEntity<List<PirataDTO>> listarPiratas() {

        List<PirataDTO> piratas =  pirataService.listarPiratas();
        return ResponseEntity.ok(piratas);

    }

    // Procurar Pirata por ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um pirata por Id", description = "Rota lista pirata pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pirata encontrado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Pirata não encontrado")
    })

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
    @Operation(summary = "Altera pirata por Id", description = "Rota altera pirata pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pirata alterado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Pirata não encontrado, não foi possivel realizar alterações")
    })
    public ResponseEntity<?> alterarPirata(
        @Parameter(description = "Necessário enviar ID na URL da requisição")
        @PathVariable Long id,
        @Parameter(description = "Necessário enviar os dados do pirata a ser atualizado no corpo(body) da requisição")
        @RequestBody PirataDTO pirataAtualizado) {


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
    @Operation(summary = "Deletar pirata por Id", description = "Rota lista o pirata pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pirata encontrado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Pirata não encontrado")
    })
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
