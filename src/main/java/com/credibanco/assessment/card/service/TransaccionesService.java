package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.AnularTransaccionRequestDto;
import com.credibanco.assessment.card.dto.AnularTransaccionResponseDto;
import com.credibanco.assessment.card.dto.CrearTransaccionRequestDto;
import com.credibanco.assessment.card.dto.CrearTransaccionResponseDto;
import com.credibanco.assessment.card.model.TransaccionesEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransaccionesService {


    ResponseEntity<CrearTransaccionResponseDto> crearTransaccion(CrearTransaccionRequestDto requestDto);

    ResponseEntity<AnularTransaccionResponseDto> anularTransaccion(AnularTransaccionRequestDto request);

    ResponseEntity<List<TransaccionesEntity>> consultartodaslastransacciones();
}
