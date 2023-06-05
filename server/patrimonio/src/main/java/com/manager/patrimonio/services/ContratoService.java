package com.manager.patrimonio.services;

import com.manager.patrimonio.dtos.ContratoOutput;
import com.manager.patrimonio.models.ContratoEquipamento;
import com.manager.patrimonio.models.ContratoImovel;
import com.manager.patrimonio.models.ContratoVeiculo;
import com.manager.patrimonio.repositories.ContratoEquipamentoRepository;
import com.manager.patrimonio.repositories.ContratoImovelRepository;
import com.manager.patrimonio.repositories.ContratoVeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratoService {

    private final ContratoVeiculoRepository contratoVeiculoRepository;
    private final ContratoImovelRepository contratoImovelRepository;
    private final ContratoEquipamentoRepository contratoEquipamentoRepository;

    public List<ContratoOutput> getAllContratos(){
        List<ContratoOutput> contratosVeiculo =
                ContratoVeiculo.convertToOutputList(contratoVeiculoRepository.findAll());

        List<ContratoOutput> contratosEquipamento =
                ContratoEquipamento.convertToOutputList(contratoEquipamentoRepository.findAll());

        List<ContratoOutput> contratosImovel =
                ContratoImovel.convertToOutputList(contratoImovelRepository.findAll());

        List<ContratoOutput> allContratos = new ArrayList<>();

        allContratos.addAll(contratosVeiculo);
        allContratos.addAll(contratosEquipamento);
        allContratos.addAll(contratosImovel);

        return allContratos;
    }
}
