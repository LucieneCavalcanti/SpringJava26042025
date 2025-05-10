package br.edu.fatecriopreto.projeto26042025.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecriopreto.projeto26042025.entities.CompraEntity;
import br.edu.fatecriopreto.projeto26042025.service.CompraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/compras")
public class CompraController {
    @SuppressWarnings("unused")
    private final CompraService compraService;
    @GetMapping
    public ResponseEntity<List<CompraEntity>> listarTodos() {
        List<CompraEntity> lista = compraService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<CompraEntity> incluir(@RequestBody CompraEntity Compra) {
        CompraEntity novo = compraService.incluir(Compra);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
     @PutMapping("/{id}")
    public ResponseEntity<CompraEntity> editar(@PathVariable int id, @RequestBody CompraEntity usuarioDetails) {
        CompraEntity atualizado = compraService.editar(id,usuarioDetails);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        compraService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
