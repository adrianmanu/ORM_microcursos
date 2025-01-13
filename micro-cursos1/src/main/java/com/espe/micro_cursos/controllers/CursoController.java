package com.espe.micro_cursos.controllers;

import com.espe.micro_cursos.model.entity.Curso;
import com.espe.micro_cursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService service;
    // Crear un curso
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Curso curso) {
        // La fecha de creación se asignará automáticamente en el método @PrePersist
        Curso nuevoCurso = service.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }
    // Obtener todos los cursos
    @GetMapping
    public List<Curso> listar() {
        return service.findAll();
    }
    // Obtener un curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Curso> curso = service.findById(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso no encontrado");
    }
    // Actualizar un curso
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Curso curso, @PathVariable Long id) {
        Optional<Curso> cursoExistente = service.findById(id);
        if (cursoExistente.isPresent()) {
            Curso cursoActualizado = cursoExistente.get();
            cursoActualizado.setNombre(curso.getNombre());
            cursoActualizado.setDescripcion(curso.getDescripcion());
            cursoActualizado.setCreditos(curso.getCreditos());
            // La fecha de creación no se modifica porque está configurada como "updatable = false"
            return ResponseEntity.ok(service.save(cursoActualizado));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso no encontrado");
    }
    // Eliminar un curso
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Curso> curso = service.findById(id);
        if (curso.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok("Curso eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso no encontrado");
    }
}
