package com.example.demo.servicios;

import com.example.demo.helpers.ValidacionCiudad;
import com.example.demo.modelos.Ciudad;
import com.example.demo.repositorios.CiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CiudadServicio {
    @Autowired
    ValidacionCiudad validacionCiudad;
    @Autowired
    CiudadRepositorio ciudadRepositorio;

    public Ciudad guardarCiudad(Ciudad datosCiudad) throws Exception{
        try {
            if (validacionCiudad.validarCiudad(datosCiudad.getCiudad())) {
                return ciudadRepositorio.save(datosCiudad);
            }
            throw new Exception("Ciudad invalida, Revise por favor");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Ciudad> buscarTodosLasCiudades()throws Exception{
        try {
            return ciudadRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Ciudad buscarCiudadPorId(Integer id_Ciudad) throws Exception{
        try {
            if (ciudadRepositorio.findById(id_Ciudad).isPresent()){
                return ciudadRepositorio.findById(id_Ciudad).get();
            }else{
                throw new Exception("Ciudad no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
