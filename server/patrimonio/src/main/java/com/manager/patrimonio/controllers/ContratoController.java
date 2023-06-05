package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.ContratoOutput;
import com.manager.patrimonio.services.ContratoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ResponseEntity<List<ContratoOutput>> getAllContratos(){
        return ResponseEntity.ok(contratoService.getAllContratos());
    }
}
