/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyecto_exa.service;


import com.example.proyecto_exa.model.Depto;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface DeptoService {
        public Depto crear(Depto p);

    public Depto findById(Long id);

    public List<Depto> findByAll();

    public void delete(Long id);
    
}
