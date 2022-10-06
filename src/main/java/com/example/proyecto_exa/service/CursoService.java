/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyecto_exa.service;

import com.example.proyecto_exa.model.Curso;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CursoService {
    public Curso crear(Curso p);

    public Curso findById(Long id);

    public List<Curso> findByAll();

    public void delete(Long id);
    
}
