package com.example.demo.servicios;

import com.example.demo.helpers.ValidacionProveedor;
import com.example.demo.modelos.Ciudad;
import com.example.demo.modelos.Proveedor;
import com.example.demo.repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio {
    @Autowired
    ValidacionProveedor validacionProveedor;
    @Autowired
    ProveedorRepositorio proveedorRepositorio;


    public Proveedor guardarProveedor(Proveedor datosProveedor)throws Exception {
        try {
            if (!validacionProveedor.validarTipoPersona(datosProveedor.getTipoPersona())){
                throw new Exception("Tipo persona invalida, Revise por favor");
            }
            if (!validacionProveedor.validarNit(datosProveedor.getNit())){
                throw new Exception("Nit invalido, Revise por favor");
            }
            if (!validacionProveedor.validarNombreRazonSocial(datosProveedor.getRazonSocial())){
                throw new Exception("Razon social invalida, revise por favor");
            }
            if (!validacionProveedor.validarTelefono(datosProveedor.getTelefonoContacto())){
                throw new Exception("Telefono invalido, Revise por favor");
            }
            if (!validacionProveedor.validarEmail(datosProveedor.getEmail())){
                throw new Exception("Correo invalido, Revise por favor");
            }
            if (!validacionProveedor.validarRepresentanteLegal(datosProveedor.getRepresentanteLegal())){
                throw new Exception("Representante legal invalido, Revise por favor");
            }
            if (!validacionProveedor.validarDireccion(datosProveedor.getDireccion())){
                throw new Exception("Direccion invalida, Revise por favor");
            }

            return proveedorRepositorio.save(datosProveedor);

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Proveedor buscarProovedorPorId(Integer id_usuario)throws Exception{
        try {
            if (proveedorRepositorio.findById(id_usuario).isPresent()){
                return proveedorRepositorio.findById(id_usuario).get();
            }else {
                throw new Exception("Proveedor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Proveedor> buscarTodosLosProveedores()throws Exception{
        try {
            return proveedorRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}



