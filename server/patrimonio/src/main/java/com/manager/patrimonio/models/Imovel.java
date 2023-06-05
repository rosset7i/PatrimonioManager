package com.manager.patrimonio.models;

import com.manager.patrimonio.dtos.ImovelOutput;
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
public class Imovel {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String endereco;
    private String descricao;
    @OneToMany(mappedBy = "imovel")
    private List<ContratoImovel> contratoImovel;

    public static ImovelOutput convertToOutput(Imovel imovel){
        return ImovelOutput.builder()
                .id(imovel.getId())
                .nome(imovel.getNome())
                .endereco(imovel.getEndereco())
                .descricao(imovel.getDescricao())
                .build();
    }

    public static List<ImovelOutput> convertToOutputList(List<Imovel> imoveis){
        return imoveis.stream()
                .map(Imovel::convertToOutput)
                .collect(Collectors.toList());
    }
}
