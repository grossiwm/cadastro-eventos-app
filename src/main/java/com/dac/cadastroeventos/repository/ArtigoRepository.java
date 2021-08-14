package com.dac.cadastroeventos.repository;

import com.dac.cadastroeventos.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

    @Override
    Optional<Artigo> findById(Long aLong);

    @Query(value="select a.autores from artigo a where a.id = :id")
    List<Artigo> buscaAutoresDeArtigo(@Param("id") Long artigoId);
}
