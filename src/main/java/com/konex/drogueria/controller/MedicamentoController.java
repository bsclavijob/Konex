package com.konex.drogueria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konex.drogueria.model.Medicamento;
import com.konex.drogueria.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;

	@GetMapping(value = "/listar")
	public ResponseEntity<List<Medicamento>> listar() {
		return ResponseEntity.ok(medicamentoService.listar());
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<Medicamento> buscar(@PathVariable("id") Long id) {
		return ResponseEntity.ok(medicamentoService.buscar(id));
	}
	
	@PostMapping(value = "/crear")
	public ResponseEntity<Boolean> crear(@RequestBody Medicamento medicamento) {
		medicamentoService.crear(medicamento);
		return ResponseEntity.ok(Boolean.TRUE);
	}
}
