package com.example.demo.repositorios;

import com.example.demo.modelos.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad,Integer> {
}
