package com.konex.drogueria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konex.drogueria.model.Medicamento;
import com.konex.drogueria.model.MedicamentoRequest;
import com.konex.drogueria.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Override
	public List<Medicamento> listar() {
		return medicamentoRepository.findAll();
	}

	@Override
	public Medicamento buscar(Long id) {
		Optional<Medicamento> opt = medicamentoRepository.findById(id);
		return opt.isPresent() ? opt.get(): null;
	}

	@Override
	public Medicamento crear(MedicamentoRequest medicamento) {
		Medicamento medicamentoEntity = new Medicamento();
		medicamentoEntity.setId(medicamento.getId());
		medicamentoEntity.setNombre(medicamento.getNombre());
		medicamentoEntity.setLaboratorio(medicamento.getLaboratorio());
		medicamentoEntity.setFechaFabricacion(medicamento.getFechaFabricacion());
		medicamentoEntity.setFechaVencimiento(medicamento.getFechaVencimiento());
		medicamentoEntity.setCantidadStock(medicamento.getCantidadStock());
		medicamentoEntity.setValorUnitario(medicamento.getValorUnitario());
		return medicamentoRepository.save(medicamentoEntity);
	}

	@Override
	public Medicamento actualizar(Medicamento medicamento) {
		if(buscar(medicamento.getId()).equals(null)) return null;
			return medicamentoRepository.save(medicamento);
	}

	@Override
	public void eliminar(Long id) {
		medicamentoRepository.deleteById(id);
	}
	
	
}
