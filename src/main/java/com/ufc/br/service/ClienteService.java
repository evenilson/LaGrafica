package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Cliente;
import com.ufc.br.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void adicionarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	public void excluirCliente(Long codigo) {
		clienteRepository.deleteById(codigo);
		
	}

	public Cliente buscarClientePorId(Long codigo) {
		return clienteRepository.getOne(codigo);
	}

}
