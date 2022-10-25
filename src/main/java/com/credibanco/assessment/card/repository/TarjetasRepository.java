package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.model.TarjetasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarjetasRepository extends JpaRepository<TarjetasEntity, String> {

    Optional<TarjetasEntity> findByPan(String pan);

}
