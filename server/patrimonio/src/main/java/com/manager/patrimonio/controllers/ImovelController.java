package com.manager.patrimonio.controllers;

import com.manager.patrimonio.repositories.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ImovelController {

    private final ImovelRepository imovelRepository;
}
