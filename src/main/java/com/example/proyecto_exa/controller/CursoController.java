/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyecto_exa.controller;

import com.example.proyecto_exa.model.Curso;
import com.example.proyecto_exa.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
     CursoService curspService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> listar(){
        return new ResponseEntity<>(curspService.findByAll(),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public String crear(@RequestBody Curso u){    
     String mensaje="";
        if (u.getNombre().equals("") || u.getDescripcion().equals("") || u.getNivel().equals("")  || u.getIdprofesor().equals("")) {
            mensaje ="no pueden haber campos nulos";
            
        } else {
            if (u.getNombre().length()<25 || u.getDescripcion().length()<50 || u.getNivel().length()<50) {
                mensaje="El nombre debe tener minimo 25 caracteres y el resto de campo 50 caracteres";
            } else {
                 mensaje="persona creada correctamente";
                 curspService.crear(u);
            }
           
        }
        
        
    return mensaje;
}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminar(@PathVariable  Long id){
        curspService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Long id){
        return new ResponseEntity<>(curspService.findById(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso u){
        Curso curso = buscarusu(id); 
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            curso.setNombre(u.getNombre());
            curso.setDescripcion(u.getDescripcion());
            curso.setIdprofesor(u.getIdprofesor());
            curso.setNivel(u.getNivel());

            return new ResponseEntity<>(curspService.crear(u),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Curso buscarusu(Long id){
        return curspService.findById(id);
    }
    
}
