package com.manager.patrimonio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
}
