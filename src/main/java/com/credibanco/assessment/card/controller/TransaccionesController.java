package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.AnularTransaccionRequestDto;
import com.credibanco.assessment.card.dto.AnularTransaccionResponseDto;
import com.credibanco.assessment.card.dto.CrearTransaccionRequestDto;
import com.credibanco.assessment.card.dto.CrearTransaccionResponseDto;
import com.credibanco.assessment.card.model.TransaccionesEntity;
import com.credibanco.assessment.card.service.impl.TransaccionesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionesController {

    @Autowired
    TransaccionesImpl service;

    @PostMapping(path = "/crear")
    public ResponseEntity<CrearTransaccionResponseDto> crearTransaccion(@Valid @RequestBody CrearTransaccionRequestDto request) {
        return service.crearTransaccion(request);
    }

    @PutMapping(path = "/anular")
    public ResponseEntity<AnularTransaccionResponseDto> anularTransaccion(@Valid @RequestBody AnularTransaccionRequestDto request) {
        return service.anularTransaccion(request);
    }

    @CrossOrigin
    @GetMapping(path = "/consultarTodas")
    public ResponseEntity<List<TransaccionesEntity>> consultarTransacciones() {
        return service.consultartodaslastransacciones();
    }
}
