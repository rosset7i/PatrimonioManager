package com.manager.patrimonio.models;

import com.manager.patrimonio.dtos.ContratoOutput;
import com.manager.patrimonio.enums.TipoContrato;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class Contrato {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @OneToOne
    private Veiculo veiculo;
    @OneToOne
    private Equipamento equipamento;
    @OneToOne
    private Imovel imovel;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    @Enumerated(value = EnumType.STRING)
    private TipoContrato tipoContrato;

    public static ContratoOutput convertToOutput(Contrato contratoVeiculo){
        if(contratoVeiculo.getTipoContrato() == TipoContrato.VEICULO){
            return ContratoOutput.builder()
                    .id(contratoVeiculo.getId())
                    .nome(contratoVeiculo.getNome())
                    .nomeAgregado(contratoVeiculo.getVeiculo().getModelo())
                    .dataInicio(contratoVeiculo.getDataFinal())
                    .dataFinal(contratoVeiculo.getDataFinal())
                    .tipoContrato(contratoVeiculo.getTipoContrato())
                    .build();
        }
        if(contratoVeiculo.getTipoContrato() == TipoContrato.EQUIPAMENTO){
            return ContratoOutput.builder()
                    .id(contratoVeiculo.getId())
                    .nome(contratoVeiculo.getNome())
                    .nomeAgregado(contratoVeiculo.getEquipamento().getNome())
                    .dataInicio(contratoVeiculo.getDataFinal())
                    .dataFinal(contratoVeiculo.getDataFinal())
                    .tipoContrato(contratoVeiculo.getTipoContrato())
                    .build();
        }
        else{
            return ContratoOutput.builder()
                    .id(contratoVeiculo.getId())
                    .nome(contratoVeiculo.getNome())
                    .nomeAgregado(contratoVeiculo.getImovel().getNome())
                    .dataInicio(contratoVeiculo.getDataFinal())
                    .dataFinal(contratoVeiculo.getDataFinal())
                    .tipoContrato(contratoVeiculo.getTipoContrato())
                    .build();
        }

    }

    public static List<ContratoOutput> convertToOutputList(List<Contrato> contratoVeiculos){
        return contratoVeiculos.stream()
                .map(Contrato::convertToOutput)
                .collect(Collectors.toList());
    }
}
