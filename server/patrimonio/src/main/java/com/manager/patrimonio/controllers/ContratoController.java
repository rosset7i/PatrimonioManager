package com.manager.patrimonio.controllers;

import com.manager.patrimonio.repositories.ContratoEquipamentoRepository;
import com.manager.patrimonio.repositories.ContratoImovelRepository;
import com.manager.patrimonio.repositories.ContratoVeiculoRepository;
import com.manager.patrimonio.repositories.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/contratos")
public class ContratoController {

    private final ContratoVeiculoRepository contratoVeiculoRepository;
    private final ContratoImovelRepository contratoImovelRepository;
    private final ContratoEquipamentoRepository contratoEquipamentoRepository;
}
