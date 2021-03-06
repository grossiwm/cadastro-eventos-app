package com.dac.cadastroeventos.repository;

import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {

    @Override
    Optional<Volume> findById(Long a);

    @Query(value="select v.artigos from volume v where v.id = :id")
    List<Artigo> buscaArtigosDeVolume(@Param("id") Long volumeId);

    @Query(value = "select au.* from volume v" +
            " inner join artigo a on a.volume_id = v.id" +
            " inner join autor au on au.artigo_id = a.id group by au.id", nativeQuery = true)
    List<Map<Object, Object>> buscaAutoresDeVolume(@Param("id") Long volumeId);
}
