package com.example.prepratica;

import com.example.prepratica.Model.XPTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdRepository extends JpaRepository<XPTO, Long> {

    List<XPTO> findByNome(String nome);
}
