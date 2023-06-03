package com.manager.patrimonio.controllers;

import com.manager.patrimonio.repositories.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
}
