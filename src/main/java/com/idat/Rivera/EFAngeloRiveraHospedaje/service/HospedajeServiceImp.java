package com.idat.Rivera.EFAngeloRiveraHospedaje.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.idat.Rivera.EFAngeloRiveraHospedaje.dto.HospedajeDTO;
import com.idat.Rivera.EFAngeloRiveraHospedaje.model.Hospedaje;
import com.idat.Rivera.EFAngeloRiveraHospedaje.repository.HospedajeRepository;

public class HospedajeServiceImp implements HospedajeService {
	@Autowired
	private HospedajeRepository repository;

	@Override
	public List<HospedajeDTO> listar() {
		List<HospedajeDTO> listadto = new ArrayList<>();
		HospedajeDTO dto = null;
				
		for (Hospedaje hospedaje : repository.findAll()) {
			dto = new HospedajeDTO();
			dto.setNom(hospedaje.getNombre());
			dto.setCod(hospedaje.getIdHospedaje());
			listadto.add(dto);
		}
		
	
		return listadto;
	}

	@Override
	public HospedajeDTO obtenerId(Integer id) {
		
      Hospedaje alumno = repository.findById(id).orElse(null);
		
		HospedajeDTO dto = new HospedajeDTO();
		dto.setNom(alumno.getNombre());
		dto.setCod(alumno.getIdHospedaje());
		
		return dto;
	}

	@Override
	public void guardar(HospedajeDTO hospedaje) {
		
		Hospedaje hos = new Hospedaje();
		hos.setNombre(hospedaje.getNom());
		hos.setIdHospedaje(hospedaje.getCod());
		
		repository.save(hos);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void actualizar(HospedajeDTO hospedaje) {
		Hospedaje hos = new Hospedaje();
		hos.setNombre(hospedaje.getNom());
		hos.setIdHospedaje(hospedaje.getCod());
		
		
		repository.saveAndFlush(hos);

	}

}
