package com.example.demo.controladores;

import com.example.demo.modelos.Ciudad;
import com.example.demo.modelos.Pais;
import com.example.demo.servicios.CiudadServicio;
import com.example.demo.servicios.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("prueba/v2/ciudad")
public class CiudadControlador {

    @Autowired
    CiudadServicio ciudadServicio;

    @PostMapping
    public ResponseEntity<?> guardarCiudad(@RequestBody Ciudad datosCiudad){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ciudadServicio.guardarCiudad(datosCiudad));
        }catch (Exception error){
            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

    }

    @GetMapping
    public ResponseEntity<?> consultarPais(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ciudadServicio.buscarTodosLasCiudades());
        }catch (Exception error){
            Map<String,Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp",LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);

        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarCiudadPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ciudadServicio.buscarCiudadPorId(id));
        }catch (Exception error){
            Map<String,Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp",LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }
}
