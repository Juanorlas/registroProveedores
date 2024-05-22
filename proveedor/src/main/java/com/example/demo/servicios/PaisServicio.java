package com.example.demo.servicios;

import com.example.demo.helpers.ValidacionPais;
import com.example.demo.modelos.Pais;
import com.example.demo.repositorios.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaisServicio {
    @Autowired
    ValidacionPais validacionPais;
    @Autowired
    PaisRepositorio paisRepositorio;

    public Pais guardarPais(Pais datosPais) throws Exception{
        try {
            if (!validacionPais.validarPais(datosPais.getPais())){
                throw new Exception("Pais invalido, Revise por favor");
            }
            return paisRepositorio.save(datosPais);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Pais> buscarTodoslosPaises()throws Exception{
        try {
            return paisRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Pais buscarPaisPorId(Integer paisId) throws Exception{
        try {
            if (paisRepositorio.findById(paisId).isPresent()){
                return paisRepositorio.findById(paisId).get();
            }else{
                throw new Exception("Pais no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
