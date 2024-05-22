package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departamentoId;

    @Column(name = "Departamento",nullable = false,length = 50)
    private String departamento;

    public Departamento() {
    }

    public Departamento(Integer departamentoId, String departamento) {
        this.departamentoId = departamentoId;
        this.departamento = departamento;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
