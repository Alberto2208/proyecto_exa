/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyecto_exa.service;

import com.example.proyecto_exa.model.Depto;
import com.example.proyecto_exa.repository.DptoRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class DeptoServiceImpl implements DeptoService{
     @Autowired
     public DptoRepository dptorepository;


    @Override
    public Depto crear(Depto p) {
        return dptorepository.save(p);

    }

    @Override
    public Depto findById(Long id) {
         return dptorepository.findById(id).orElse(null);

    }

    @Override
    public List<Depto> findByAll() {
        return dptorepository.findAll();

    }

    @Override
    public void delete(Long id) {
        dptorepository.deleteById(id);

    }
    
}
