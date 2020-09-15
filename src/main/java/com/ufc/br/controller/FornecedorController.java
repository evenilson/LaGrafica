package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Fornecedor;
import com.ufc.br.service.FornecedorService;

@Controller
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	
	@RequestMapping("/fornecedor")
	public String fornecedoresPage() {
		return "FornecedoresPage";
	}
	
	@RequestMapping("/fornecedor/form")
	public ModelAndView fornecedoresForm() {
		ModelAndView mv = new ModelAndView("CadastrarFornecedor");
		mv.addObject("fornecedor", new Fornecedor());
		return mv;
	}
	
	@RequestMapping("/fornecedor/cadastrar")
	public ModelAndView cadastrarFornecedor(Fornecedor fornecedor) {
		
		fornecedorService.adicionarFornecedor(fornecedor);
		
		ModelAndView mv = new ModelAndView("redirect:/fornecedor/listar");
		return mv;
	}
	
	@RequestMapping("/fornecedor/listar")
	public ModelAndView listarFornecedor() {
		
		List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
		ModelAndView mv = new ModelAndView("ListarFornecedor");
		mv.addObject("listaDeFornecedores", fornecedores);
		
		return mv;
	}
	
	@RequestMapping("/fornecedor/excluir/{codigo}")
	public ModelAndView excluirFornecedor(@PathVariable Long codigo) {
		fornecedorService.excluirFornecedor(codigo);
		
		ModelAndView mv = new ModelAndView("redirect:/fornecedor/listar");
		return mv;
	}
	
	@RequestMapping("/fornecedor/atualizar/{codigo}")
	public ModelAndView atualizarFornecedor(@PathVariable Long codigo) {
		Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(codigo);
		ModelAndView mv = new ModelAndView("CadastrarFornecedor");
		mv.addObject("fornecedor", fornecedor);
		
		return mv;
	}
}
