package com.example.demo.controladores;

import com.example.demo.modelos.Proveedor;
import com.example.demo.servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("prueba/v2/proveedor")
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio proveedorServicio;

    @PostMapping
    public ResponseEntity<?> guardarProveedor(@RequestBody Proveedor datosProveedor){
        try {
            Proveedor proveedorGuardado = proveedorServicio.guardarProveedor(datosProveedor);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedorGuardado);
        } catch (Exception error) {
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarProveedores(){
        try {
            List<Proveedor> proveedores = proveedorServicio.buscarTodosLosProveedores();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedores);
        } catch (Exception error) {
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarProveedorPorId(@PathVariable Integer id){
        try {
            Proveedor proveedor = proveedorServicio.buscarProovedorPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedor);
        } catch (Exception error) {
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }
}
