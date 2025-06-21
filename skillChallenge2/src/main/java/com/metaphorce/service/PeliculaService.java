package com.metaphorce.service;

import com.metaphorce.domain.Pelicula;
import com.metaphorce.dto.PeliculaRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeliculaService {

    void agregarPelicula(PeliculaRequestDTO peliculaRequestDTO);
    void eliminarPelicula(int id);
    List<Pelicula> obtenerPeliculas();
    List<Pelicula> obtenerPeliculasDisponibles ();
    List<Pelicula> obtenerPeliculasNoDisponibles ();
    void marcarPeliculaComoDisponible(int id);

}
