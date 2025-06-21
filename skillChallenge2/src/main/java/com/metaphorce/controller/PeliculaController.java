package com.metaphorce.controller;

import com.metaphorce.dto.PeliculaRequestDTO;
import com.metaphorce.service.PeliculaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/peliculas")
public class PeliculaController {

    private final PeliculaServiceImpl peliculaService;

    public PeliculaController(PeliculaServiceImpl peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping
    public ResponseEntity<?> agregarPelicula (@RequestBody PeliculaRequestDTO peliculaRequestDTO){
        try {
            peliculaService.agregarPelicula(peliculaRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> eliminarPelicula (@PathVariable int id){
        try {
            peliculaService.eliminarPelicula(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerPeliculas () {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaService.obtenerPeliculas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping ("/disponibles")
    public ResponseEntity<?>obtenerPeliculasDisponibles(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaService.obtenerPeliculasDisponibles());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping ("/no-disponible")
    public ResponseEntity<?> obtenerPeliculasNoDisponibles (){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaService.obtenerPeliculasNoDisponibles());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<?> marcarPeliculaComoDisponible (@PathVariable int id){
        try {
            peliculaService.marcarPeliculaComoDisponible(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
