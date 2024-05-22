package com.example.demo.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionCiudad {
    public boolean validarCiudad(String ciudad) throws Exception{
        if (ciudad.length()==0){
            throw new Exception("La ciudad no puede estar vacia");
        }
        if (ciudad.length()>50){
            throw new Exception("La ciudad no puede tener mas de 50 caracteres");
        }
        String regex="/^[a-zA-ZÁÉÍÓÚáéíóúÑñ\\s'’-]+$/\n";
        if (ValidacionPatron.evaluarPatron(ciudad,regex)){
            throw new Exception("Revisa la ciudad ingresada esta puede tener mayusculas, minusculas");
        }
        return true;
    }
}
