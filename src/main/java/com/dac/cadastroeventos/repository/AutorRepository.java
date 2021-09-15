package com.dac.cadastroeventos.repository;

import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Override
    Optional<Autor> findById(Long aLong);

    List<Autor> findAutorsByArtigo(Artigo artigo);
}
