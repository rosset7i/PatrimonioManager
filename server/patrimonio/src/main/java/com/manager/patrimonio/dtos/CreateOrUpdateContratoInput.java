package com.manager.patrimonio.dtos;

import com.manager.patrimonio.enums.TipoContrato;
import com.manager.patrimonio.models.Contrato;
import com.manager.patrimonio.models.Equipamento;
import com.manager.patrimonio.models.Imovel;
import com.manager.patrimonio.models.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CreateOrUpdateContratoInput {
    private Long id;
    private String nome;
    private Long veiculo;
    private Long equipamento;
    private Long imovel;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private TipoContrato tipoContrato;
}
