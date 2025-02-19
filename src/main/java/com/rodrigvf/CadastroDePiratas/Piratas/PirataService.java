package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PirataService {

    private final PirataRepository pirataRepository;
    private final PirataMapper pirataMapper;

    public PirataService(PirataRepository pirataRepository, PirataMapper pirataMapper) {
        this.pirataRepository = pirataRepository;
        this.pirataMapper = pirataMapper;
    }

    public List<PirataDTO> listarPiratas() {
        List<PirataModel> piratas = pirataRepository.findAll();
        return piratas.stream()
                .map(pirataMapper::map)
                .collect(Collectors.toList());
    }

    public PirataDTO buscarPirataPorId(Long id) {
        Optional<PirataModel> pirataPorId = pirataRepository.findById(id);
        return pirataPorId.map(pirataMapper::map).orElse(null);
    }

    public PirataDTO criarPirata(PirataDTO pirataDTO) {
        PirataModel pirata = pirataMapper.map(pirataDTO);
        pirata = pirataRepository.save(pirata);
        return pirataMapper.map(pirata);
    }

    public void deletarPirataPorId(Long id) {
        pirataRepository.deleteById(id);
    }

    public PirataDTO alterarPirata(Long id, PirataDTO pirataDTO) {
        Optional<PirataModel> pirataExistente = pirataRepository.findById(id);
        if (pirataExistente.isPresent()) {
            PirataModel pirataAtualizado = pirataMapper.map(pirataDTO);
            pirataAtualizado.setId(id);
            PirataModel pirataSalvo = pirataRepository.save(pirataAtualizado);
            return pirataMapper.map(pirataSalvo);
        }
        return null;
    }

}
