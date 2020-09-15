package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Fornecedor;
import com.ufc.br.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public void adicionarFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}
	
	public List<Fornecedor> listarFornecedores(){
		return fornecedorRepository.findAll();
	}
	public void excluirFornecedor(Long codigo) {
		fornecedorRepository.deleteById(codigo);
		
	}

	public Fornecedor buscarFornecedorPorId(Long codigo) {
		return fornecedorRepository.getOne(codigo);
	}
}
