package com.dac.cadastroeventos.repository;

import com.dac.cadastroeventos.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {

    @Override
    Optional<Volume> findById(Long aLong);
}
