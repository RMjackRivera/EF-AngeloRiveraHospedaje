package com.idat.Rivera.EFAngeloRiveraHospedaje.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.Rivera.EFAngeloRiveraHospedaje.dto.HospedajeDTO;
import com.idat.Rivera.EFAngeloRiveraHospedaje.service.HospedajeService;

@Controller
@RequestMapping("/api/hospedaje/v1")
public class HospedajeController {
	
	@Autowired
	private HospedajeService service;
	
	@GetMapping("/hola")
	public @ResponseBody String hola(){
		return "hola que tal como estas";
	}
	
	@GetMapping("/listar")
	public @ResponseBody List<HospedajeDTO> listar(){
		return service.listar();
	}
	
	@GetMapping("/listar/{id}")
	public @ResponseBody HospedajeDTO obtenerId(@PathVariable Integer id) {
		return service.obtenerId(id);
	}
	
	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody HospedajeDTO dto) {
		service.guardar(dto);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody HospedajeDTO dto) {
		service.actualizar(dto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}

}
