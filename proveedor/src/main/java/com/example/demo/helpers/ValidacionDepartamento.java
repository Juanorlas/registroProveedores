package com.example.demo.helpers;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;




@Component
public class ValidacionDepartamento {
    public boolean validarDepartamento(String departamento) throws Exception{
        if (departamento.length()==0){
            throw new Exception("El departamento no puede estar vacia");
        }
        if (departamento.length()>50){
            throw new Exception("El departamento no puede tener mas de 50 caracteres");
        }
        String regex="/^[a-zA-ZÁÉÍÓÚáéíóúÑñ\\s'’-]+$/\n";
        if (ValidacionPatron.evaluarPatron(departamento,regex)){
            throw new Exception("Revisa el departamento ingresado");
        }
        return true;
    }


}
