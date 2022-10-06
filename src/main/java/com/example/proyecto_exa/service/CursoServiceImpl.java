/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyecto_exa.service;

import com.example.proyecto_exa.model.Curso;
import com.example.proyecto_exa.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
     public CursoRepository cursopository;

    @Override
    public Curso crear(Curso p) {
        return cursopository.save(p);
    }

    @Override
    public Curso findById(Long id) {
         return cursopository.findById(id).orElse(null);
    }

    @Override
    public List<Curso> findByAll() {
        return cursopository.findAll();
    }

    @Override
    public void delete(Long id) {
        cursopository.deleteById(id);
    }
    
    
}
