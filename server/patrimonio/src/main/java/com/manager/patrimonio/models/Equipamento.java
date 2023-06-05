package com.manager.patrimonio.models;

import com.manager.patrimonio.dtos.EquipamentoOutput;
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
public class Equipamento {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataAquisicao;
    @OneToMany(mappedBy = "equipamento")
    private List<ContratoEquipamento> contratoEquipamento;

    public static EquipamentoOutput convertToOutput(Equipamento equipamento){
        return EquipamentoOutput.builder()
                .id(equipamento.getId())
                .nome(equipamento.getNome())
                .descricao(equipamento.getDescricao())
                .dataAquisicao(equipamento.getDataAquisicao())
                .build();
    }

    public static List<EquipamentoOutput> convertToOutputList(List<Equipamento> equipamentos){
        return equipamentos.stream()
                .map(Equipamento::convertToOutput)
                .collect(Collectors.toList());
    }
}
