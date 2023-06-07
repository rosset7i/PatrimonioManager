package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.EquipamentoOutput;
import com.manager.patrimonio.models.Equipamento;
import com.manager.patrimonio.repositories.EquipamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/equipamentos")
public class EquipamentoController {

    private final EquipamentoRepository equipamentoRepository;

    @GetMapping
    public ResponseEntity<List<EquipamentoOutput>> getAllEquipamentos(){
        return ResponseEntity.ok(Equipamento.convertToOutputList(equipamentoRepository.findAll()));
    }

    @PostMapping
    public ResponseEntity createEquipamento(@RequestBody Equipamento equipamento){
        return ResponseEntity.created(URI.create("api/v1/equipamentos"))
                .body(equipamentoRepository.save(equipamento));
    }

    @PutMapping
    public ResponseEntity updateEquipamento(@RequestBody Equipamento equipamento){
        return ResponseEntity.accepted()
                .body(equipamentoRepository.save(equipamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEquipamentoById(@PathVariable Long id){
        equipamentoRepository.deleteById(id);

        return ResponseEntity.ok()
                .build();
    }
}
