/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyecto_exa.repository;


import com.example.proyecto_exa.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ACER
 */
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{
    
}
