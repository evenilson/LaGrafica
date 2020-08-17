package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Cliente;
import com.ufc.br.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/")
	public String paginaIncial() {
		return "index";
	}
	
	@RequestMapping("/cliente")
	public String clientesPage() {
		return "ClientesPage";
	}
	
	@RequestMapping("/cliente/form")
	public ModelAndView clientesForm() {
		ModelAndView mv = new ModelAndView("CadastrarCliente");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	
	@RequestMapping("/cliente/cadastrar")
	public ModelAndView cadastrarCliente(Cliente cliente) {
		
		clienteService.adicionarCliente(cliente);
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
		return mv;
	}
	
	@RequestMapping("/cliente/listar")
	public ModelAndView listarCliente() {
		
		List<Cliente> clientes = clienteService.listarClientes();
		ModelAndView mv = new ModelAndView("ListarCliente");
		mv.addObject("listaDeClientes", clientes);
		
		return mv;
	}
	
	@RequestMapping("/cliente/excluir/{codigo}")
	public ModelAndView excluirCliente(@PathVariable Long codigo) {
		clienteService.excluirCliente(codigo);
		
		ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
		return mv;
	}
	
	@RequestMapping("/cliente/atualizar/{codigo}")
	public ModelAndView atualizarCliente(@PathVariable Long codigo) {
		Cliente cliente = clienteService.buscarClientePorId(codigo);
		ModelAndView mv = new ModelAndView("CadastrarCliente");
		mv.addObject("cliente", cliente);
		
		return mv;
	}

}
