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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdprofesor", query = "SELECT p FROM Profesor p WHERE p.idprofesor = :idprofesor"),
    @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesor.findByDireccion", query = "SELECT p FROM Profesor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Profesor.findByTelefono", query = "SELECT p FROM Profesor p WHERE p.telefono = :telefono")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesor")
    private Long idprofesor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private List<Curso> cursoList;
    @JoinColumn(name = "iddepto", referencedColumnName = "iddepto")
    @JsonIgnore
    @ManyToOne(optional = false)
    private Depto iddepto;

    public Profesor() {
    }

    public Profesor(Long idprofesor, String nombre, String direccion, String telefono, List<Curso> cursoList, Depto iddepto) {
        this.idprofesor = idprofesor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cursoList = cursoList;
        this.iddepto = iddepto;
    }

    public Long getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Long idprofesor) {
        this.idprofesor = idprofesor;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public Depto getIddepto() {
        return iddepto;
    }

    public void setIddepto(Depto iddepto) {
        this.iddepto = iddepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.proyecto_exa.model.Profesor[ idprofesor=" + idprofesor + " ]";
    }
    
}
