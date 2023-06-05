package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.ImovelOutput;
import com.manager.patrimonio.models.Imovel;
import com.manager.patrimonio.repositories.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/imoveis")
public class ImovelController {

    private final ImovelRepository imovelRepository;

    public ResponseEntity<List<ImovelOutput>> getAllImoveis(){
        return ResponseEntity.ok(Imovel.convertToOutputList(imovelRepository.findAll()));
    }
}
