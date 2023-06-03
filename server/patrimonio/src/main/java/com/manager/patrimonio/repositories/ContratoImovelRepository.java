package com.manager.patrimonio.repositories;

import com.manager.patrimonio.models.ContratoImovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoImovelRepository extends JpaRepository<ContratoImovel, Long> {
}
