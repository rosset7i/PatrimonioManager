package com.manager.patrimonio.repositories;

import com.manager.patrimonio.models.ContratoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoVeiculoRepository extends JpaRepository<ContratoVeiculo, Long> {
}
