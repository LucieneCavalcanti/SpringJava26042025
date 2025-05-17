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

import br.edu.fatecriopreto.projeto26042025.entities.ItensCompraEntity;
import br.edu.fatecriopreto.projeto26042025.service.ItensCompraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/itenscompra")
public class ItensCompraController {
    @SuppressWarnings("unused")
    private final ItensCompraService itemService;
    @GetMapping
    public ResponseEntity<List<ItensCompraEntity>> listarTodos() {
        List<ItensCompraEntity> lista = itemService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<ItensCompraEntity> incluir(@RequestBody ItensCompraEntity itemCompra) {
        ItensCompraEntity novo = itemService.incluir(itemCompra);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
     @PutMapping("/{id}")
    public ResponseEntity<ItensCompraEntity> editar(@PathVariable int id, @RequestBody ItensCompraEntity itemCompra) {
        ItensCompraEntity atualizado = itemService.editar(id,itemCompra);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        itemService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
