package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Proveedor;

    @Column(name = "tipo_Persona",nullable = false,length = 50)
    private String tipoPersona;
    @Column(name = "Nit",nullable = false,length = 50)
    private String nit;
    @Column(name = "Nombre_Razon_Social",nullable = false,length = 50)
    private String razonSocial;
    @Column(name = "Representante_Legal",nullable = false,length = 50)
    private String representanteLegal;
    @Column(name = "telefono_Contacto",nullable = false,length = 40)
    private String telefonoContacto;
    @Column(name = "Email",nullable = false,length = 50)
    private String email;
    @Column(name = "Direccion",nullable = false,length = 150)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "paisId",nullable = true)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "departamentoId",nullable = true)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "ciudadId",nullable = true)
    private Ciudad ciudad;

    public Proveedor() {
    }

    public Proveedor(Integer id_Proveedor, String tipoPersona, String nit, String razonSocial, String representanteLegal, String telefonoContacto, String email, String direccion) {
        this.id_Proveedor = id_Proveedor;
        this.tipoPersona = tipoPersona;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.representanteLegal = representanteLegal;
        this.telefonoContacto = telefonoContacto;
        this.email = email;
        this.direccion = direccion;
    }

    public Integer getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(Integer id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
