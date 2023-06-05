package com.manager.patrimonio.dtos;

import com.manager.patrimonio.enums.TipoContrato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ContratoOutput {
    private Long id;
    private String nome;
    private Long idAgregado;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private TipoContrato tipoContrato;
}
