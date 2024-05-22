package com.example.demo.repositorios;

import com.example.demo.modelos.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais,Integer> {
}
