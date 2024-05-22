package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ciudadId;

    @Column(name = "ciudad",nullable = false,length = 50)
    private String ciudad;

    public Ciudad() {
    }

    public Ciudad(Integer ciudadId, String ciudad) {
        this.ciudadId = ciudadId;
        this.ciudad = ciudad;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
