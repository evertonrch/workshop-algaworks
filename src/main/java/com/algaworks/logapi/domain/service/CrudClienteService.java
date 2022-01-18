package com.algaworks.logapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.logapi.domain.exception.DomainException;
import com.algaworks.logapi.domain.model.Cliente;
import com.algaworks.logapi.domain.repository.ClienteRepository;

@Service
public class CrudClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailemUso = repository.findByEmail(cliente.getEmail())
			.stream().anyMatch(c -> !c.equals(cliente));
		
		if(emailemUso)
			throw new DomainException("Já existe um cliente cadastrado com este email.");
		
		return repository.save(cliente);		
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		repository.deleteById(clienteId);
	}
}
