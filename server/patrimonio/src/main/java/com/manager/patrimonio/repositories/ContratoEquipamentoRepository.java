package com.manager.patrimonio.repositories;

import com.manager.patrimonio.models.ContratoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoEquipamentoRepository extends JpaRepository<ContratoEquipamento, Long> {
}
