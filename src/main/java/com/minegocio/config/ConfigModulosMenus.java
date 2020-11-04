package com.minegocio.config;


import com.minegocio.home.controller.MenuDTO;
import com.minegocio.home.controller.ModuloDTO;

public class ConfigModulosMenus {
	
	public static ModuloDTO base() {
		ModuloDTO dto = new ModuloDTO();		
		dto.nombre="Base";
		dto.permission="base";
		
		dto.menus.add(new MenuDTO("Negocio","/base/infonegocio",null,"base.infonegocio"));
		dto.menus.add(new MenuDTO("Sucursales","/base/sucursales",null,"base.sucursales"));
		dto.menus.add(new MenuDTO("Empleados","/base/empleados",null,"base.empleados"));
		dto.menus.add(new MenuDTO("Paises","/base/paises",null,"base.paises"));
		dto.menus.add(new MenuDTO("Departamentos","/base/departamentos",null,"base.departamentos"));
		dto.menus.add(new MenuDTO("Ciudades","/base/ciudades",null,"base.ciudades"));
		dto.menus.add(new MenuDTO("Barrios","/base/barrios",null,"base.barrios"));
		
		return dto;
	}
	
	public static ModuloDTO compras() {
		ModuloDTO dto = new ModuloDTO();		
		dto.nombre="Compras";
		dto.permission="compras";
		
		dto.menus.add(new MenuDTO("Compras","/compras/compras",null,"compras.compras"));
		dto.menus.add(new MenuDTO("Ordenes de Compra","/compras/ordenescompras",null,"compras.ordenescompras"));
		dto.menus.add(new MenuDTO("Proveedores","/compras/proveedores",null,"compras.proveedores"));

		return dto;
	}
	
	public static ModuloDTO ventas() {
		ModuloDTO dto = new ModuloDTO();		
		dto.nombre="Ventas";
		dto.permission="ventas";
		
		dto.menus.add(new MenuDTO("Ventas","/ventas/ventas",null,"ventas.ventas"));
		dto.menus.add(new MenuDTO("Pedidos","/ventas/pedidos",null,"ventas.pedidos"));
		dto.menus.add(new MenuDTO("Clientes","/ventas/clientes",null,"ventas.clientes"));
		dto.menus.add(new MenuDTO("Vendedores","/ventas/vendedores",null,"ventas.vendedores"));
		
		return dto;
	}
	
	public static ModuloDTO inventario() {
		ModuloDTO dto = new ModuloDTO();		
		dto.nombre="Inventario";
		dto.permission="inventario";
		
		dto.menus.add(new MenuDTO("Categorias","/inventario/categorias",null,"inventario.categorias"));
		dto.menus.add(new MenuDTO("Depósitos","/inventario/depositos",null,"inventario.depositos"));
		dto.menus.add(new MenuDTO("Marcas","/inventario/marcas",null,"inventario.marcas"));
		dto.menus.add(new MenuDTO("Productos","/inventario/productos",null,"inventario.productos"));
		
		return dto;
	}
	
	public static ModuloDTO tesoreria() {
		ModuloDTO dto = new ModuloDTO();		
		dto.nombre="Tesoreria";
		dto.permission="tesoreria";
		
		dto.menus.add(new MenuDTO("Bancos","/tesoreria/bancos",null,"tesoreria.bancos"));
		dto.menus.add(new MenuDTO("Cajas","/tesoreria/cajas",null,"tesoreria.cajas"));
		dto.menus.add(new MenuDTO("Cajeros","/tesoreria/cajeros",null,"tesoreria.cajeros"));
		dto.menus.add(new MenuDTO("Cuentas","/tesoreria/cuentas",null,"tesoreria.cuentas"));
		dto.menus.add(new MenuDTO("Movimientos","/tesoreria/movimientos",null,"tesoreria.movimientos"));
		
		return dto;
	}
	

}
