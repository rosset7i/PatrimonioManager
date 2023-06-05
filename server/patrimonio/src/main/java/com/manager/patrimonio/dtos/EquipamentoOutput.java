package com.manager.patrimonio.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class EquipamentoOutput {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataAquisicao;
}
