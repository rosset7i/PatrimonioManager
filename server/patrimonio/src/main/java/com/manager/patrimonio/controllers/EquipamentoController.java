package com.manager.patrimonio.controllers;

import com.manager.patrimonio.repositories.EquipamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/equipamentos")
public class EquipamentoController {

    private final EquipamentoRepository equipamentoRepository;
}
