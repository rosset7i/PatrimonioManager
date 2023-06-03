package com.manager.patrimonio.controllers;

import com.manager.patrimonio.repositories.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/imoveis")
public class ImovelController {

    private final ImovelRepository imovelRepository;
}
