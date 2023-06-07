package com.manager.patrimonio.models;

import com.manager.patrimonio.dtos.VeiculoOutput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Veiculo {
    @Id
    @GeneratedValue
    private Long id;
    private int ano;
    private String placa;
    private String modelo;
    @OneToMany(mappedBy = "veiculo")
    private List<Contrato> contratos;

    public static VeiculoOutput convertToOutput(Veiculo veiculo){
        return VeiculoOutput.builder()
                .id(veiculo.getId())
                .ano(veiculo.getAno())
                .placa(veiculo.getPlaca())
                .modelo(veiculo.getModelo())
                .build();
    }

    public static List<VeiculoOutput> convertToOutputList(List<Veiculo> veiculo){
        return veiculo.stream()
                .map(Veiculo::convertToOutput)
                .collect(Collectors.toList());
    }
}

