package com.example.demo.servicios;

import com.example.demo.helpers.ValidacionDepartamento;
import com.example.demo.modelos.Departamento;
import com.example.demo.repositorios.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartamentoServicio {
    @Autowired
    ValidacionDepartamento validacionDepartamento;
    @Autowired
    DepartamentoRepositorio departamentoRepositorio;

    public Departamento guardarDepartamento(Departamento datosDepartamento) throws Exception{
        try {
            if (!validacionDepartamento.validarDepartamento(datosDepartamento.getDepartamento())){
                throw new Exception("Departamento invalido, Revise por favor");
            }
            return departamentoRepositorio.save(datosDepartamento);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Departamento> buscarTodosLosDepartamentos()throws Exception{
        try {
            return departamentoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Departamento buscarDepartamentoPorId(Integer departamentoId) throws Exception{
        try {
            if (departamentoRepositorio.findById(departamentoId).isPresent()){
                return departamentoRepositorio.findById(departamentoId).get();
            }else{
                throw new Exception("Departamento no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
