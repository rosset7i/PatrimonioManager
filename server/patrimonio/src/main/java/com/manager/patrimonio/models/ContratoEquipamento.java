package com.manager.patrimonio.models;

import com.manager.patrimonio.dtos.ContratoOutput;
import com.manager.patrimonio.enums.TipoContrato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ContratoEquipamento {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @OneToOne
    private Equipamento equipamento;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public static ContratoOutput convertToOutput(ContratoEquipamento contratoEquipamento){
        return ContratoOutput.builder()
                .id(contratoEquipamento.getId())
                .nome(contratoEquipamento.getNome())
                .dataInicio(contratoEquipamento.getDataFinal())
                .dataFinal(contratoEquipamento.getDataFinal())
                .tipoContrato(TipoContrato.EQUIPAMENTO)
                .build();
    }

    public static List<ContratoOutput> convertToOutputList(List<ContratoEquipamento> contratoEquipamentos){
        return contratoEquipamentos.stream()
                .map(ContratoEquipamento::convertToOutput)
                .collect(Collectors.toList());
    }
}
