/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyecto_exa.controller;


import com.example.proyecto_exa.model.Profesor;
import com.example.proyecto_exa.service.ProfesorService;
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
@RequestMapping("/api/profesor")
public class ProfesorController {
     @Autowired
     ProfesorService profeService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Profesor>> listar(){
        return new ResponseEntity<>(profeService.findByAll(),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public String crear(@RequestBody Profesor u){    
     String mensaje="";
        if (u.getNombre().equals("") || u.getDireccion().equals("") || u.getIddepto().equals("") || u.getIdprofesor().equals("") || u.getTelefono().equals("")) {
            mensaje ="no pueden haber campos nulos";
            
        } else {
            if (u.getNombre().length()<25 || u.getDireccion().length()<50 || u.getTelefono().length()<50) {
                mensaje="El nombre debe tener minimo 25 caracteres y el resto de campo 50 caracteres";
            } else {
                 mensaje="persona creada correctamente";
                 profeService.crear(u);
            }
           
        }
        
        
    return mensaje;
}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminar(@PathVariable  Long id){
        profeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Profesor> buscar(@PathVariable Long id){
        return new ResponseEntity<>(profeService.findById(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor u){
        Profesor profe = buscarusu(id); 
        if (profe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            profe.setNombre(u.getNombre());
            profe.setDireccion(u.getDireccion());
            profe.setTelefono(u.getTelefono());
            profe.setIddepto(u.getIddepto());
          
                    
        

            return new ResponseEntity<>(profeService.crear(u),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Profesor buscarusu(Long id){
        return profeService.findById(id);
    }
    
}
