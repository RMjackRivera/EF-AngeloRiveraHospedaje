package com.idat.Rivera.EFAngeloRiveraHospedaje.service;

import java.util.List;


import com.idat.Rivera.EFAngeloRiveraHospedaje.dto.HospedajeDTO;

public interface HospedajeService {
	List<HospedajeDTO> listar();
	HospedajeDTO obtenerId(Integer id);
	void guardar(HospedajeDTO hospedaje);
	void eliminar(Integer id);
	void actualizar(HospedajeDTO hospedaje);
	

}
