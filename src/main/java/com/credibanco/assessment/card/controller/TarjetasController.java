package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.*;
import com.credibanco.assessment.card.model.TarjetasEntity;
import com.credibanco.assessment.card.service.impl.TarjetasImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tarjetas")

public class TarjetasController {

    @Autowired
    TarjetasImpl service;

    @PostMapping(path = "/crear")
    public ResponseEntity<CrearTarjetaResponseDto> creartarjeta(@Valid @RequestBody CrearTarjetaRequestDto request) throws Exception {
        System.out.println(request.toString());
        return service.creartarjeta(request);
    }

    @PutMapping(path = "/enrolar")
    public ResponseEntity<EnrolarTarjetaResponseDto> enrolartarjeta(@Valid @RequestBody EnrolarTarjetaRequestDto request) {
        return (ResponseEntity<EnrolarTarjetaResponseDto>) service.enrolartarjeta(request);
    }

    @GetMapping(path = "/consultar")
    public ResponseEntity<ConsultarTarjetaResponseDto> consultar(@RequestParam(name = "pan") String pan) {
        return service.tarjetas(pan);
    }

    @DeleteMapping(path = "/eliminar")
    public ResponseEntity<EliminarTarjetaResponseDto> eliminar(@Valid @RequestBody EliminarTarjetaRequestDto request) {
        return service.eliminarTarjeta(request);
    }

    @CrossOrigin
    @GetMapping(path = "consultarTodas")
    public ResponseEntity<List<TarjetasEntity>> consultarTodasTarjetas() {
        return service.tarjetasTodas();
    }


}
