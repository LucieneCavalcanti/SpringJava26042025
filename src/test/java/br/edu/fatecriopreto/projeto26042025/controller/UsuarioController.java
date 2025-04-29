package br.edu.fatecriopreto.projeto26042025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecriopreto.projeto26042025.entities.UsuarioEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @SuppressWarnings("unused")
    private final UsuarioEntity usuario;
}
