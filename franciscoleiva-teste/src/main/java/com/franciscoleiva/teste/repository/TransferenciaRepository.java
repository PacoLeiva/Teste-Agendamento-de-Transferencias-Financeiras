package com.franciscoleiva.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franciscoleiva.teste.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

}
