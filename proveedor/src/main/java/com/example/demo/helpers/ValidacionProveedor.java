package com.example.demo.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionProveedor {
    public boolean validarTipoPersona(String tipoPersona)throws Exception{
        if (tipoPersona.length()==0){
            throw new Exception("El tipo de persona no puede quedar vacio");
        }
        if (tipoPersona.length()>50){
            throw new Exception("No puede superar mas de 50 caracteres el tipo de persona");
        }
        String regex="^[a-zA-ZÀ-ÿ\\u00f1\\u00d1' ]+$\n";
        if (ValidacionPatron.evaluarPatron(tipoPersona,regex)){
            throw new Exception("Por favor verifique el nombre ingresado solo acepta espacios y letras");
        }
        return true;
    }

    public boolean validarNit(String nit)throws Exception{
        if (nit.length()==0){
            throw new Exception("El nit no puede quedar vacio");
        }
        if (nit.length()>60){
            throw new Exception("El nit no puede contener mas de 60 caracteres");
        }
        String regex="/^\\d{2}\\.\\d{3}\\.\\d{3}-\\d$/";
        if (ValidacionPatron.evaluarPatron(nit,regex)){
            throw new Exception("El nit solo debe contener numeros");
        }
        return true;
    }

    public boolean validarNombreRazonSocial(String nombreRazonSocial)throws Exception{
        if (nombreRazonSocial.length()==0){
            throw new Exception("El nombre de la razon social no puede quedar vacio");
        }
        if (nombreRazonSocial.length()>50){
            throw new Exception("La razon social no puede contener mas de 50 caracteres");
        }
        String regex="/^[A-Za-z0-9\\s.,'&()-]+$/\n";
        if (ValidacionPatron.evaluarPatron(nombreRazonSocial,regex)){
            throw new Exception("Razon social solo puede contener letras y caracteres especiales");
        }
        return true;
    }

    public boolean validarRepresentanteLegal(String representanteLegal)throws Exception{
        if (representanteLegal.length()==0){
            throw new Exception("El nombre del representante no puede estar vacio");
        }
        if (representanteLegal.length()>50){
            throw new Exception("El nombre del representante legal no puede tener mas de 50 caracteres");
        }
        String regex="/^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s'-]+$/\n";
        if (ValidacionPatron.evaluarPatron(representanteLegal,regex)){
            throw new Exception("Representante legal solo puede contener letras");
        }
        return true;
    }

    public boolean validarTelefono(String telefono)throws Exception{
        if (telefono.length()==0){
            throw new Exception("El telefono no puede estar vacio");
        }
        if (telefono.length()>30){
            throw new Exception("El telefono no puede contener mas de 30 caracteres");
        }
        String regex="/^\\+?\\d{1,3}[\\s-]?\\(?\\d{1,4}\\)?[\\s-]?\\d{1,4}[\\s-]?\\d{1,4}[\\s-]?\\d{1,9}$/\n";
        if (ValidacionPatron.evaluarPatron(telefono,regex)){
            throw new Exception("Revisa el telefono ingresado ya que puede faltar algun caracter especial o codigo de pais, Ejemplo" +
                    "de como lo puedes hacer  +123 456 789 0123");
        }
        return true;
    }

    public boolean validarEmail(String Email)throws Exception{
        if (Email.length()==0){
            throw new Exception("El email no puede estar vacio");
        }
        if (Email.length()>70){
            throw new Exception("El eamil no puede contener mas de 70 caracteres");
        }
        String regex="/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$/\n";
        if (ValidacionPatron.evaluarPatron(Email,regex)){
            throw new Exception("Revisa que el email este bien escrito");
        }
        return true;
    }
    public boolean validarDireccion(String direccion)throws Exception{
        if (direccion.length()==0){
            throw new Exception("La direccion no puede estar vacia");
        }
        if (direccion.length()>150){
            throw new Exception("La direccion no puede tener mas de 150 caracteres");
        }
        String regex="/^[a-zA-Z0-9\\s.,'-]+$/\n";
        if (ValidacionPatron.evaluarPatron(direccion,regex)){
            throw new Exception("Revisa la direccion, esta permite mayusculas, minusculas, guiones");
        }
        return true;
    }


}
