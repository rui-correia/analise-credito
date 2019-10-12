package com.desktop.analisecredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.desktop.analisecredito.domain.Cliente;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

}
