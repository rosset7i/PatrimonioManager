package com.manager.patrimonio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {
    @Id
    @GeneratedValue
    private Long id;
    private String rua;
    private String bairro;
    private String numero;
    private String cep;
    private Cidade cidade;

}
