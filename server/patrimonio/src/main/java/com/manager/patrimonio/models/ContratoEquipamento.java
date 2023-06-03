package com.manager.patrimonio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ContratoEquipamento {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @OneToOne
    private Equipamento equipamento;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
}
