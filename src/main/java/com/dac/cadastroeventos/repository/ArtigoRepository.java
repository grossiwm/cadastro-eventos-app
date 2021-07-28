package com.dac.cadastroeventos.repository;

import com.dac.cadastroeventos.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

    @Override
    Optional<Artigo> findById(Long aLong);
}
