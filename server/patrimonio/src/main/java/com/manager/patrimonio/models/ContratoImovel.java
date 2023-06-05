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
public class ContratoImovel {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @OneToOne
    private Imovel imovel;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public static ContratoOutput convertToOutput(ContratoImovel contratoImovel){
        return ContratoOutput.builder()
                .id(contratoImovel.getId())
                .nome(contratoImovel.getNome())
                .dataInicio(contratoImovel.getDataFinal())
                .dataFinal(contratoImovel.getDataFinal())
                .tipoContrato(TipoContrato.IMOVEL)
                .build();
    }

    public static List<ContratoOutput> convertToOutputList(List<ContratoImovel> contratoImoveis){
        return contratoImoveis.stream()
                .map(ContratoImovel::convertToOutput)
                .collect(Collectors.toList());
    }
}
