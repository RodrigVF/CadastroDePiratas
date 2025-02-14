package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PirataService {

    private PirataRepository pirataRepository;
    private PirataMapper pirataMapper;

    public PirataService(PirataRepository pirataRepository, PirataMapper pirataMapper) {
        this.pirataRepository = pirataRepository;
        this.pirataMapper = pirataMapper;
    }

    public List<PirataModel> listarPiratas() {
        return pirataRepository.findAll();
    }

    public PirataModel buscarPirataPorId(Long id) {
        Optional<PirataModel> pirataPorId = pirataRepository.findById(id);
        return pirataPorId.orElse(null);
    }

    public PirataDTO criarPirata(PirataDTO pirataDTO) {
        PirataModel pirata = pirataMapper.map(pirataDTO);
        pirata = pirataRepository.save(pirata);
        return pirataMapper.map(pirata);
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
