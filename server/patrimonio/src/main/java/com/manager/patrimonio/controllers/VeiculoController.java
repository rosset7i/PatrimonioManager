package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.VeiculoOutput;
import com.manager.patrimonio.models.Veiculo;
import com.manager.patrimonio.repositories.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;

    @GetMapping
    public ResponseEntity<List<VeiculoOutput>> getAllVeiculos(){
        return ResponseEntity.ok(Veiculo.convertToOutputList(veiculoRepository.findAll()));
    }

    @PostMapping
    public ResponseEntity createVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.created(URI.create("api/v1/veiculos"))
                .body(veiculoRepository.save(veiculo));
    }

    @PutMapping
    public ResponseEntity updateVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.accepted()
                .body(veiculoRepository.save(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVeiculoById(@PathVariable Long id){
        veiculoRepository.deleteById(id);
        return ResponseEntity.ok()
                .build();
    }
}
