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
public class ContratoVeiculo {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @OneToOne
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public static ContratoOutput convertToOutput(ContratoVeiculo contratoVeiculo){
        return ContratoOutput.builder()
                .id(contratoVeiculo.getId())
                .nome(contratoVeiculo.getNome())
                .dataInicio(contratoVeiculo.getDataFinal())
                .dataFinal(contratoVeiculo.getDataFinal())
                .tipoContrato(TipoContrato.VEICULO)
                .build();
    }

    public static List<ContratoOutput> convertToOutputList(List<ContratoVeiculo> contratoVeiculos){
        return contratoVeiculos.stream()
                .map(ContratoVeiculo::convertToOutput)
                .collect(Collectors.toList());
    }
}
