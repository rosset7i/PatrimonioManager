package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.VeiculoOutput;
import com.manager.patrimonio.models.Veiculo;
import com.manager.patrimonio.repositories.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;

    public ResponseEntity<List<VeiculoOutput>> getAllVeiculos(){
        return ResponseEntity.ok(Veiculo.convertToOutputList(veiculoRepository.findAll()));
    }
}
