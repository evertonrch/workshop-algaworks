package com.algaworks.logapi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.logapi.domain.model.Cliente;
import com.algaworks.logapi.domain.repository.ClienteRepository;
import com.algaworks.logapi.domain.service.CrudClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CrudClienteService service;

	@GetMapping
	public List<Cliente> listar() {		
		return repository.findAll();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return repository.findById(clienteId)
					.map(ResponseEntity::ok)
					.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adiciona(@Valid @RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
			@Valid @RequestBody Cliente cliente) {
		if (!repository.existsById(clienteId)) {
			return ResponseEntity.noContent().build();	
		}
		
		cliente.setId(clienteId);
		cliente = service.salvar(cliente);
		return ResponseEntity.ok(cliente);		
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> delete(@PathVariable Long clienteId){
		if (!repository.existsById(clienteId)) {
			return ResponseEntity.noContent().build();	
		}
		
		service.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
}
