package com.manager.patrimonio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ContratoImovel {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Imovel imovel;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
}
