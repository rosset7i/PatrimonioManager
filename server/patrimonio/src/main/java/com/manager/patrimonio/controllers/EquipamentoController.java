package com.manager.patrimonio.controllers;

import com.manager.patrimonio.repositories.EquipamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class EquipamentoController {

    private final EquipamentoRepository equipamentoRepository;
}
