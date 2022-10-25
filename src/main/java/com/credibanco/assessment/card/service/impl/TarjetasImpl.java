package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.dto.*;
import com.credibanco.assessment.card.model.TarjetasEntity;
import com.credibanco.assessment.card.repository.TarjetasRepository;
import com.credibanco.assessment.card.service.TarjetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TarjetasImpl implements TarjetasService {

    @Autowired
    TarjetasRepository tarjetasRepository;

    public ResponseEntity<CrearTarjetaResponseDto> creartarjeta(CrearTarjetaRequestDto request) throws Exception {
        if (!(request.getTipo().equals("Credito") || request.getTipo().equalsIgnoreCase("Debito")))
            throw new RuntimeException("tipo debe ser Credito o Debito ");

        try {
            Random r = new Random();
            int numeroRandom = r.nextInt((100 - 1) + 1) + 1;
            String estado = "Creada";
            TarjetasEntity entity = new TarjetasEntity();
            entity.setCedula(request.getCedula());
            entity.setPan(request.getPan());
            entity.setTipo(request.getTipo());
            entity.setNombre(request.getTitular());
            entity.setTelefono(request.getTelefono());
            entity.setEstado(estado);
            entity.setNumerovalidacion(numeroRandom);
            entity.setFecha(new Date());
            tarjetasRepository.save(entity);
            CrearTarjetaResponseDto response = new CrearTarjetaResponseDto();
            response.setCodigo("00");
            response.setMensaje("Exito");
            response.setNumerovalidacion(entity.getNumerovalidacion());
            response.setPan(enmascarar(request.getPan()));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            CrearTarjetaResponseDto response = new CrearTarjetaResponseDto();
            response.setCodigo("01");
            response.setMensaje("Fallido");
            response.setNumerovalidacion(response.getNumerovalidacion());
            response.setPan(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public Object enrolartarjeta(EnrolarTarjetaRequestDto request) {
        Optional<TarjetasEntity> tarjetas = tarjetasRepository.findById(request.getPan());
        if (tarjetas.isPresent()) {
            System.out.println("Si existe");
            if (request.getNumerovalidacion() == tarjetas.get().getNumerovalidacion()) {
                System.out.println("Enrolada");
                tarjetas.get().setEstado("Enrolada");
                tarjetasRepository.save(tarjetas.get());
                EnrolarTarjetaResponseDto enrolarTarjetaResponseDto = new EnrolarTarjetaResponseDto();
                enrolarTarjetaResponseDto.setCodigo("00");
                enrolarTarjetaResponseDto.setMensaje("Exito");
                enrolarTarjetaResponseDto.setPan(enmascarar(tarjetas.get().getPan()));
                return new ResponseEntity<>(enrolarTarjetaResponseDto, HttpStatus.OK);
            } else {
                System.out.println("El numero de validacion no concuerda");
                EnrolarTarjetaResponseDto enrolarTarjetaResponseDto = new EnrolarTarjetaResponseDto();
                enrolarTarjetaResponseDto.setCodigo("02");
                enrolarTarjetaResponseDto.setMensaje("Numero de validaion invalido");
                enrolarTarjetaResponseDto.setPan(enmascarar(tarjetas.get().getPan()));
                return new ResponseEntity<>(enrolarTarjetaResponseDto, HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            EnrolarTarjetaResponseDto enrolarTarjetaResponseDto = new EnrolarTarjetaResponseDto();
            enrolarTarjetaResponseDto.setCodigo("01");
            enrolarTarjetaResponseDto.setMensaje("Tarjeta no existe");
            enrolarTarjetaResponseDto.setPan(enmascarar(request.getPan()));
            return new ResponseEntity<>(enrolarTarjetaResponseDto, HttpStatus.NOT_FOUND);
        }

    }

    public String enmascarar(String pan) {
        String resultado = pan.substring(0, 6) + "*****" + pan.substring(pan.length() - 4);
        return resultado;
    }

    @Override
    public ResponseEntity<ConsultarTarjetaResponseDto> tarjetas(String pan) {
        Optional<TarjetasEntity> tarjetas = tarjetasRepository.findById(pan);
        if (tarjetas.isPresent()) {
            ConsultarTarjetaResponseDto consultarTarjataResponse = new ConsultarTarjetaResponseDto();
            consultarTarjataResponse.setPan(tarjetas.get().getPan());
            consultarTarjataResponse.setEstado(tarjetas.get().getEstado());
            consultarTarjataResponse.setTitular(tarjetas.get().getNombre());
            consultarTarjataResponse.setCedula(tarjetas.get().getCedula());
            consultarTarjataResponse.setTelefono(tarjetas.get().getTelefono());
            return new ResponseEntity<>(consultarTarjataResponse, HttpStatus.OK);

        } else {
            ConsultarTarjetaResponseDto consultarTarjataResponseDto = new ConsultarTarjetaResponseDto();
            return new ResponseEntity<>(consultarTarjataResponseDto, HttpStatus.NOT_FOUND);

        }

    }

    @Override
    public ResponseEntity<EliminarTarjetaResponseDto> eliminarTarjeta(EliminarTarjetaRequestDto request) {
        Optional<TarjetasEntity> tarjetas = tarjetasRepository.findById(request.getPan());
        if (tarjetas.isPresent()) {
            if (request.getNumerovalidacion() == tarjetas.get().getNumerovalidacion()) {
                tarjetasRepository.delete(tarjetas.get());
                EliminarTarjetaResponseDto eliminarTarjetaResponseDto = new EliminarTarjetaResponseDto();
                eliminarTarjetaResponseDto.setCodigo("00");
                eliminarTarjetaResponseDto.setMensaje("Se ha eliminado la tarjeta");
                return new ResponseEntity<>(eliminarTarjetaResponseDto, HttpStatus.OK);
            } else {
                EliminarTarjetaResponseDto eliminarTarjetaResponseDto = new EliminarTarjetaResponseDto();
                eliminarTarjetaResponseDto.setCodigo("01");
                eliminarTarjetaResponseDto.setMensaje("No se ha eliminado la tarjeta");
                return new ResponseEntity<>(eliminarTarjetaResponseDto, HttpStatus.NOT_ACCEPTABLE);
            }


        } else {
            EliminarTarjetaResponseDto eliminarTarjetaResponseDto = new EliminarTarjetaResponseDto();
            eliminarTarjetaResponseDto.setCodigo("01");
            eliminarTarjetaResponseDto.setMensaje("No se ha eliminado la tarjeta");
            return new ResponseEntity<>(eliminarTarjetaResponseDto, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<List<TarjetasEntity>> tarjetasTodas() {
        List<TarjetasEntity> tarjetas = tarjetasRepository.findAll();
        for (int i = 0; i < tarjetas.size(); i++) {
            String ntarjetas = tarjetas.get(i).getPan();
            String panenmascarado = enmascarar(ntarjetas);
            tarjetas.get(i).setPan(panenmascarado);
        }
        return new ResponseEntity<>(tarjetas, HttpStatus.OK);
    }


}
