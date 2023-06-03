package com.manager.patrimonio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
}
