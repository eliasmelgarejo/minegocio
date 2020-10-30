package com.minegocio.core;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


public interface IController {
	
	@GetMapping
	public String home();
	@GetMapping()
	public String index(Model model);
	@GetMapping("new")
	public String create(Model model);
	@PostMapping
	public String create(@ModelAttribute Object entity);
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model);
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model);
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Object entity);
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id);
	
}
