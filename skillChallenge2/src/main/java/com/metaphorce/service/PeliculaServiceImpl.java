package com.metaphorce.service;

import com.metaphorce.domain.Pelicula;
import com.metaphorce.dto.PeliculaRequestDTO;
import com.metaphorce.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    private final PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public void agregarPelicula(PeliculaRequestDTO peliculaRequestDTO) {
        try {
            peliculaRepository.save(new Pelicula(0, peliculaRequestDTO.nombre(), peliculaRequestDTO.disponible()));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarPelicula(int id) {
        try {
            peliculaRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> obtenerPeliculas() {
        try {
            return peliculaRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> obtenerPeliculasDisponibles() {
        try {
            return peliculaRepository.findByDisponibleTrue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> obtenerPeliculasNoDisponibles() {
        try {
            return peliculaRepository.findByDisponibleFalse();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void marcarPeliculaComoDisponible(int id) {
        Optional<Pelicula> peliculaOptional = peliculaRepository.findById(id);

        if (peliculaOptional.isPresent()) {
            Pelicula pelicula = peliculaOptional.get();
            pelicula.setDisponible(true);
            peliculaRepository.save(pelicula);
        } else {
            throw new RuntimeException("Pelicula no encontrada");
        }
    }
}
