package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.*;
import com.credibanco.assessment.card.model.TarjetasEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TarjetasService {

    ResponseEntity<CrearTarjetaResponseDto> creartarjeta(CrearTarjetaRequestDto request) throws Exception;

    Object enrolartarjeta(EnrolarTarjetaRequestDto request);


    ResponseEntity<ConsultarTarjetaResponseDto> tarjetas(String pan);


    ResponseEntity<EliminarTarjetaResponseDto> eliminarTarjeta(EliminarTarjetaRequestDto request);

    ResponseEntity<List<TarjetasEntity>> tarjetasTodas();
}
