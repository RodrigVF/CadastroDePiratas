package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/piratas/ui")
public class PirataControllerUi {

    private final PirataService pirataService;

    public PirataControllerUi(PirataService pirataService) {
        this.pirataService = pirataService;
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarPirata(Model model) {
        model.addAttribute("pirata", new PirataDTO());
        return "adicionarPirata";
    }

    @PostMapping("/criar")
    public String criarPirata(@ModelAttribute PirataDTO pirata, RedirectAttributes redirectAttributes) {

        pirataService.criarPirata(pirata);
        redirectAttributes.addFlashAttribute("mensagem", "Pirata cadastrado com sucesso!");
        return "redirect:/piratas/ui/listar";

    }

    @GetMapping("/listar")
    public String listarPiratas(Model model) {

        List<PirataDTO> piratas =  pirataService.listarPiratas();
        model.addAttribute("piratas", piratas);
        return "listarPiratas";

    }

    @GetMapping("/listar/{id}")
    public String buscarPirataPorId(@PathVariable Long id, Model model) {

        PirataDTO pirata = pirataService.buscarPirataPorId(id);

        if ( pirata != null) {
            model.addAttribute("pirata", pirata);
            return "detalhesPirata";
        } else {
            model.addAttribute("mensagem", "Pirata não encontrado");
            return "listarPiratas";
        }

    }

    @GetMapping("/deletar/{id}")
    public String deletarPirataPorId(@PathVariable Long id) {
        pirataService.deletarPirataPorId(id);
        return "redirect:/piratas/ui/listar";
    }

}
