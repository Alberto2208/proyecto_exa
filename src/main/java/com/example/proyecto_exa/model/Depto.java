/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyecto_exa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "depto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depto.findAll", query = "SELECT d FROM Depto d"),
    @NamedQuery(name = "Depto.findByIddepto", query = "SELECT d FROM Depto d WHERE d.iddepto = :iddepto"),
    @NamedQuery(name = "Depto.findByNombre", query = "SELECT d FROM Depto d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Depto.findByDireccion", query = "SELECT d FROM Depto d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Depto.findByDescripcion", query = "SELECT d FROM Depto d WHERE d.descripcion = :descripcion")})
public class Depto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddepto")
    private Long iddepto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepto")
    private List<Profesor> profesorList;

    public Depto() {
    }

    public Depto(Long iddepto, String nombre, String direccion, String descripcion, List<Profesor> profesorList) {
        this.iddepto = iddepto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.profesorList = profesorList;
    }

    
    public Long getIddepto() {
        return iddepto;
    }

    public void setIddepto(Long iddepto) {
        this.iddepto = iddepto;
    }

     

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepto != null ? iddepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depto)) {
            return false;
        }
        Depto other = (Depto) object;
        if ((this.iddepto == null && other.iddepto != null) || (this.iddepto != null && !this.iddepto.equals(other.iddepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.proyecto_exa.model.Depto[ iddepto=" + iddepto + " ]";
    }
    
}
