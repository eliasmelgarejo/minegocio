package com.minegocio.base.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.service.DepartamentoService;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/departamento")
public class DepartamentoController implements IController{

	private DepartamentoService service;
	
	@Override
	@GetMapping
	public String index(Model model) {
		List<Departamento> lista = service.findAll();
		model.addAttribute("lista", lista);
		return "/base/departamento/index";
	}

	@Override
	@GetMapping("new")
	public String create(Model model) {
		return "base/departamento/new";
	}

	@Override
	public String create(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String show(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Long id, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String destroy(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
