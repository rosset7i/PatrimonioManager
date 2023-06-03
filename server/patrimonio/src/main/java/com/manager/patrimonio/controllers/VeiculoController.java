package com.manager.patrimonio.controllers;

import com.manager.patrimonio.repositories.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
}
