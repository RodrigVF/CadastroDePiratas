package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PirataService {

    private PirataRepository pirataRepository;

    public PirataService(PirataRepository pirataRepository) {
        this.pirataRepository = pirataRepository;
    }

    public List<PirataModel> listarPiratas() {
        return pirataRepository.findAll();
    }


}
