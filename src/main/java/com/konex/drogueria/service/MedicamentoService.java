package com.konex.drogueria.service;

import java.util.List;

import com.konex.drogueria.model.Medicamento;
import com.konex.drogueria.model.MedicamentoRequest;

public interface MedicamentoService {
	
	public List<Medicamento> listar();
	
	public Medicamento buscar(Long id);
	
	public Medicamento crear(MedicamentoRequest medicamento);
	
	public Medicamento actualizar(Medicamento medicamento);
	
	public void eliminar(Long id);
}
