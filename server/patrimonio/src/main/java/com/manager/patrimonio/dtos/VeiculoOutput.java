package com.manager.patrimonio.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class VeiculoOutput {
    private Long id;
    private int ano;
    private String placa;
    private String modelo;
}
