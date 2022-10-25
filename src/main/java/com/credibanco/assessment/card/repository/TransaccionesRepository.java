package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.model.TransaccionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionesRepository extends JpaRepository<TransaccionesEntity, String> {
}
