/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyecto_exa.controller;


import com.example.proyecto_exa.model.Depto;
import com.example.proyecto_exa.service.DeptoService;
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
@RequestMapping("/api/depto")
public class DeptoController {
     @Autowired
     DeptoService deptoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Depto>> listar(){
        return new ResponseEntity<>(deptoService.findByAll(),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public String crear(@RequestBody Depto u){    
     String mensaje="";
        if (u.getNombre().equals("") || u.getDescripcion().equals("") || u.getDireccion().equals("") || u.getIddepto().equals("")) {
            mensaje ="no pueden haber campos nulos";
            
        } else {
            if (u.getNombre().length()<25 || u.getDescripcion().length()<50 || u.getDireccion().length()<50) {
                mensaje="El nombre debe tener minimo 25 caracteres y el resto de campo 50 caracteres";
            } else {
                 mensaje="persona creada correctamente";
                 deptoService.crear(u);
            }
           
        }
        
        
    return mensaje;
}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminar(@PathVariable  Long id){
        deptoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Depto> buscar(@PathVariable Long id){
        return new ResponseEntity<>(deptoService.findById(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Depto> actualizar(@PathVariable Long id, @RequestBody Depto u){
        Depto depto = buscarusu(id); 
        if (depto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            depto.setNombre(u.getNombre());
            depto.setDescripcion(u.getDescripcion());
            depto.setDireccion(u.getDireccion());
            

            return new ResponseEntity<>(deptoService.crear(u),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Depto buscarusu(Long id){
        return deptoService.findById(id);
    }
    
    
    
    
}
