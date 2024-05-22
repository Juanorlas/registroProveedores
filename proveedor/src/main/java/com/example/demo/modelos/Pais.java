package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paisId;

    @Column(name = "pais",nullable = false,length = 50)
    private String pais;

    public Pais() {
    }

    public Pais(Integer paisId, String pais) {
        this.paisId = paisId;
        this.pais = pais;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
