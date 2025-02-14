package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PirataService {

    private PirataRepository pirataRepository;

    public PirataService(PirataRepository pirataRepository) {
        this.pirataRepository = pirataRepository;
    }

    public List<PirataModel> listarPiratas() {
        return pirataRepository.findAll();
    }

    public PirataModel buscarPirataPorId(Long id) {
        Optional<PirataModel> pirataPorId = pirataRepository.findById(id);
        return pirataPorId.orElse(null);
    }

    public PirataModel criarPirata(PirataModel pirata) {
        return pirataRepository.save(pirata);
    }

    public void deletarPirataPorId(Long id) {
        pirataRepository.deleteById(id);
    }

    public PirataModel alterarPirata(Long id, PirataModel pirataAtualizado) {
        if (pirataRepository.existsById(id)) {
            pirataAtualizado.setId(id);
            return pirataRepository.save(pirataAtualizado);
        }
        return null;
    }

}
