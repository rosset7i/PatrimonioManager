package com.manager.patrimonio.controllers;

import com.manager.patrimonio.dtos.ContratoOutput;
import com.manager.patrimonio.dtos.CreateOrUpdateContratoInput;
import com.manager.patrimonio.models.Contrato;
import com.manager.patrimonio.models.Equipamento;
import com.manager.patrimonio.models.Imovel;
import com.manager.patrimonio.models.Veiculo;
import com.manager.patrimonio.repositories.ContratoRepository;
import com.manager.patrimonio.repositories.EquipamentoRepository;
import com.manager.patrimonio.repositories.ImovelRepository;
import com.manager.patrimonio.repositories.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/contratos")
public class ContratoController {

    private final ContratoRepository contratoRepository;
    private final VeiculoRepository veiculoRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final ImovelRepository imovelRepository;

    @GetMapping
    public ResponseEntity<List<ContratoOutput>> getAllContratos(){
        return ResponseEntity.ok(Contrato.convertToOutputList(contratoRepository.findAll()));
    }

    @PostMapping
    public ResponseEntity createContrato(@RequestBody CreateOrUpdateContratoInput input){
        Contrato contrato = new Contrato();

        contrato.setNome(input.getNome());
        contrato.setDataInicio(input.getDataInicio());
        contrato.setDataFinal(input.getDataFinal());
        contrato.setTipoContrato(input.getTipoContrato());

        if (input.getVeiculo() != null) {
            Optional<Veiculo> veiculoOptional = veiculoRepository.findById(input.getVeiculo());
            veiculoOptional.ifPresent(contrato::setVeiculo);
        }

        if (input.getEquipamento() != null) {
            Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(input.getEquipamento());
            equipamentoOptional.ifPresent(contrato::setEquipamento);
        }

        if (input.getImovel() != null) {
            Optional<Imovel> imovelOptional = imovelRepository.findById(input.getImovel());
            imovelOptional.ifPresent(contrato::setImovel);
        }
        
        return ResponseEntity.created(URI.create("api/v1/contratos"))
                .body(contratoRepository.save(contrato));
    }

    @PutMapping
    public ResponseEntity updateContrato(@RequestBody Contrato contrato){
        return ResponseEntity.accepted()
                .body(contratoRepository.save(contrato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContrato(@PathVariable Long id){
        contratoRepository.deleteById(id);
        return ResponseEntity.ok()
                .build();
    }
}
