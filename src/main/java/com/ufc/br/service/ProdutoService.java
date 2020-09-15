package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Produto;
import com.ufc.br.repository.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void adicionarProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	public void excluirProduto(Long codigo) {
		produtoRepository.deleteById(codigo);
		
	}

	public Produto buscarProdutoPorId(Long codigo) {
		return produtoRepository.getOne(codigo);
	}
}
