package com.minegocio.core;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface IController<T> {
	
	@GetMapping
	public String index(Model model,@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size);
	
	@GetMapping("new")
	public String create(Model model);
	
	@PostMapping("create")
	public String create(@ModelAttribute T entity);
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model);
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model);
	
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute T entity);
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id);
	
}
