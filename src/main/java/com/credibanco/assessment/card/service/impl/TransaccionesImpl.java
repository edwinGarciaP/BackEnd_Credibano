package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.dto.AnularTransaccionRequestDto;
import com.credibanco.assessment.card.dto.AnularTransaccionResponseDto;
import com.credibanco.assessment.card.dto.CrearTransaccionRequestDto;
import com.credibanco.assessment.card.dto.CrearTransaccionResponseDto;
import com.credibanco.assessment.card.model.TarjetasEntity;
import com.credibanco.assessment.card.model.TransaccionesEntity;
import com.credibanco.assessment.card.repository.TarjetasRepository;
import com.credibanco.assessment.card.repository.TransaccionesRepository;
import com.credibanco.assessment.card.service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesImpl implements TransaccionesService {

    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Autowired
    private TarjetasRepository tarjetasRepository;


    @Override
    public ResponseEntity<CrearTransaccionResponseDto> crearTransaccion(CrearTransaccionRequestDto request) {
        Optional<TarjetasEntity> tarjetas = tarjetasRepository.findById(request.getPan());
        if (tarjetas.isPresent()) {
            if (tarjetas.get().getEstado().equals("Enrolada")) {
                TransaccionesEntity transacciones = new TransaccionesEntity();
                transacciones.setDireccioncompra(request.getDireccioncompra());
                transacciones.setPan(request.getPan());
                transacciones.setEstadotransacion("Aprobada");
                transacciones.setNumeroreferencia(request.getNumeroreferencia());
                transacciones.setTotalcompra(request.getTotalcompra());
                transacciones.setHoraFechatransaccion(new Date());
                transaccionesRepository.save(transacciones);
                CrearTransaccionResponseDto crearTransaccionResponse = new CrearTransaccionResponseDto();
                crearTransaccionResponse.setCodigo("00");
                crearTransaccionResponse.setMensaje("Compra exitosa");
                crearTransaccionResponse.setEstadotransaccion("Aprobada");
                crearTransaccionResponse.setNumeroreferencia(transacciones.getNumeroreferencia());
                return new ResponseEntity<>(crearTransaccionResponse, HttpStatus.OK);
            } else {
                CrearTransaccionResponseDto crearTransaccionResponse = new CrearTransaccionResponseDto();
                crearTransaccionResponse.setCodigo("02");
                crearTransaccionResponse.setMensaje("Tarjeta no enrolada");
                crearTransaccionResponse.setEstadotransaccion("Rechazada");
                crearTransaccionResponse.setNumeroreferencia(crearTransaccionResponse.getNumeroreferencia());
                return new ResponseEntity<>(crearTransaccionResponse, HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            CrearTransaccionResponseDto crearTransaccionResponse = new CrearTransaccionResponseDto();
            crearTransaccionResponse.setCodigo("01");
            crearTransaccionResponse.setMensaje("Tarjeta no existe");
            crearTransaccionResponse.setEstadotransaccion("Rechazada");
            crearTransaccionResponse.setNumeroreferencia(request.getNumeroreferencia());
            return new ResponseEntity<>(crearTransaccionResponse, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<AnularTransaccionResponseDto> anularTransaccion(AnularTransaccionRequestDto request) {
        Optional<TransaccionesEntity> transacciones = transaccionesRepository.findById(request.getNumeroreferencia());
        if (transacciones.isPresent()) {
            Date actual = new Date();
            Long diferencia = (actual.getTime() - transacciones.get().getHoraFechatransaccion().getTime()) / 60000;
            if (diferencia <= 5) {
                transacciones.get().setEstadotransacion("Anulada");
                transaccionesRepository.save(transacciones.get());
                AnularTransaccionResponseDto anularTransaccionResponse = new AnularTransaccionResponseDto();
                anularTransaccionResponse.setCodigo("00");
                anularTransaccionResponse.setMensaje("Compra anulada");
                anularTransaccionResponse.setNumeroreferencia(request.getNumeroreferencia());
                return new ResponseEntity<>(anularTransaccionResponse, HttpStatus.OK);
            } else {
                AnularTransaccionResponseDto anularTransaccionResponse = new AnularTransaccionResponseDto();
                anularTransaccionResponse.setCodigo("02");
                anularTransaccionResponse.setMensaje("No se puede anular transaccion");
                anularTransaccionResponse.setNumeroreferencia(request.getNumeroreferencia());
                return new ResponseEntity<>(anularTransaccionResponse, HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            AnularTransaccionResponseDto anularTransaccionResponse = new AnularTransaccionResponseDto();
            anularTransaccionResponse.setCodigo("01");
            anularTransaccionResponse.setMensaje("numero de referencia invalido");
            anularTransaccionResponse.setNumeroreferencia(request.getNumeroreferencia());
            return new ResponseEntity<>(anularTransaccionResponse, HttpStatus.NOT_FOUND);
        }
    }


    public String enmascarar(String pan) {
        String resultado = pan.substring(0, 6) + "*****" + pan.substring(pan.length() - 4);
        return resultado;
    }

    @Override
    public ResponseEntity<List<TransaccionesEntity>> consultartodaslastransacciones() {
        List<TransaccionesEntity> todaslastransacciones = transaccionesRepository.findAll();

        for (int i = 0; i < todaslastransacciones.size(); i++) {
            String ntarjetas = todaslastransacciones.get(i).getPan();
            String panenmascarado = enmascarar(ntarjetas);
            todaslastransacciones.get(i).setPan(panenmascarado);
        }
        return new ResponseEntity<>(todaslastransacciones, HttpStatus.OK);
    }


}
