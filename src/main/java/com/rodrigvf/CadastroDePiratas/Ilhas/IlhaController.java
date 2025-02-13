package com.rodrigvf.CadastroDePiratas.Ilhas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ilhas")
public class IlhaController {

    @GetMapping("/listar")
    public String listarIlha() {
        return "Ilhas listadas com sucesso!";
    }

    @PostMapping("/criar")
    public String criarIlha() {
        return "Ilha criada com sucesso!";
    }

    @PutMapping("/alterarID")
    public String atualizarIlha() {
        return "Ilha alterada com sucesso!";
    }

    @DeleteMapping("/deletarID")
    public String deletarIlha() {
        return "Ilha deletada com sucesso!";
    }

}
