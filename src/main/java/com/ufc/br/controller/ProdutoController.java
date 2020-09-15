package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Produto;
import com.ufc.br.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private  ProdutoService produtoService;
	
	
	@RequestMapping("/produto")
	public String produtosPage() {
		return "ProdutosPage";
	}
	
	@RequestMapping("/produto/form")
	public ModelAndView produtosForm() {
		ModelAndView mv = new ModelAndView("CadastrarProduto");
		mv.addObject("produto", new Produto());
		return mv;
	}
	
	@RequestMapping("/produto/cadastrar")
	public ModelAndView cadastrarProduto(Produto produto) {
		
		produtoService.adicionarProduto(produto);
		
		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
		return mv;
	}
	
	@RequestMapping("/produto/listar")
	public ModelAndView listarProduto() {
		
		List<Produto> produtos = produtoService.listarProdutos();
		ModelAndView mv = new ModelAndView("ListarProduto");
		mv.addObject("listaDeProdutos", produtos);
		
		return mv;
	}
	
	@RequestMapping("/produto/excluir/{codigo}")
	public ModelAndView excluirProduto(@PathVariable Long codigo) {
		produtoService.excluirProduto(codigo);
		
		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
		return mv;
	}
	
	@RequestMapping("/produto/atualizar/{codigo}")
	public ModelAndView atualizarProduto(@PathVariable Long codigo) {
		Produto produto = produtoService.buscarProdutoPorId(codigo);
		ModelAndView mv = new ModelAndView("CadastrarProduto");
		mv.addObject("produto", produto);
		
		return mv;
	}
}
