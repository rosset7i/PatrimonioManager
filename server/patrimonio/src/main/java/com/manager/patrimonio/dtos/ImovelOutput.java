package com.manager.patrimonio.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ImovelOutput {
    private Long id;
    private String nome;
    private String endereco;
    private String descricao;
}
