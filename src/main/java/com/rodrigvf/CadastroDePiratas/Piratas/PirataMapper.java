package com.rodrigvf.CadastroDePiratas.Piratas;

import org.springframework.stereotype.Component;

@Component
public class PirataMapper {

    public PirataModel map(PirataDTO pirataDTO) {

        PirataModel pirataModel = new PirataModel();
        pirataModel.setId(pirataDTO.getId());
        pirataModel.setNome(pirataDTO.getNome());
        pirataModel.setEmail(pirataDTO.getEmail());
        pirataModel.setImgUrl(pirataDTO.getImgUrl());
        pirataModel.setIdade(pirataDTO.getIdade());
        pirataModel.setRecompensa(pirataDTO.getRecompensa());
        pirataModel.setIlhas(pirataDTO.getIlhas());

        return pirataModel;
    }

    public PirataDTO map(PirataModel pirataModel) {

        PirataDTO pirataDTO = new PirataDTO();
        pirataDTO.setId(pirataModel.getId());
        pirataDTO.setNome(pirataModel.getNome());
        pirataDTO.setEmail(pirataModel.getEmail());
        pirataDTO.setImgUrl(pirataModel.getImgUrl());
        pirataDTO.setIdade(pirataModel.getIdade());
        pirataDTO.setRecompensa(pirataModel.getRecompensa());
        pirataDTO.setIlhas(pirataModel.getIlhas());

        return pirataDTO;
    }

}
