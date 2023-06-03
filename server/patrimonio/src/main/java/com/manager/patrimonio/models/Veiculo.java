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
public class Veiculo {
    @Id
    @GeneratedValue
    private Long id;
    private int ano;
    private String placa;
    private String modelo;
    @OneToMany(mappedBy = "veiculo")
    private List<ContratoVeiculo> contratoVeiculo;
}

