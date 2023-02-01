package com.konex.drogueria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.konex.drogueria.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
	
}
