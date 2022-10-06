/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyecto_exa.service;

import com.example.proyecto_exa.model.Profesor;

import com.example.proyecto_exa.repository.ProfesorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ProfesorServiceImpl implements ProfesorService {
     @Autowired
     public ProfesorRepository profepository;

    @Override
    public Profesor crear(Profesor p) {
        return profepository.save(p);
    }

    @Override
    public Profesor findById(Long id) {
         return profepository.findById(id).orElse(null);
    }

    @Override
    public List<Profesor> findByAll() {
        return profepository.findAll();

    }

    @Override
    public void delete(Long id) {
        profepository.deleteById(id);

    }
    
    
}
