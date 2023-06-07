package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.ImovelOutput;
import com.manager.patrimonio.models.Imovel;
import com.manager.patrimonio.repositories.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/imoveis")
public class ImovelController {

    private final ImovelRepository imovelRepository;

    @GetMapping
    public ResponseEntity<List<ImovelOutput>> getAllImoveis(){
        return ResponseEntity.ok(Imovel.convertToOutputList(imovelRepository.findAll()));
    }

    @PostMapping
    public ResponseEntity createImovel(@RequestBody Imovel imovel){
        return ResponseEntity.created(URI.create("api/v1/imoveis"))
                .body(imovelRepository.save(imovel));
    }

    @PutMapping
    public ResponseEntity updateImovel(@RequestBody Imovel imovel){
        return ResponseEntity.accepted()
                .body(imovelRepository.save(imovel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteImovelById(@PathVariable Long id){
        imovelRepository.deleteById(id);
        return ResponseEntity.ok()
                .build();
    }
}
