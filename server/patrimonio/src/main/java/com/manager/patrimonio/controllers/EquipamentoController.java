package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.EquipamentoOutput;
import com.manager.patrimonio.models.Equipamento;
import com.manager.patrimonio.repositories.EquipamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/equipamentos")
public class EquipamentoController {

    private final EquipamentoRepository equipamentoRepository;

    public ResponseEntity<List<EquipamentoOutput>> getAllEquipamentos(){
        return ResponseEntity.ok(Equipamento.convertToOutputList(equipamentoRepository.findAll()));
    }
}
