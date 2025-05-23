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

import br.edu.fatecriopreto.projeto26042025.entities.ProdutoEntity;
import br.edu.fatecriopreto.projeto26042025.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produtos")
public class ProdutoController {
    @SuppressWarnings("unused")
    private final ProdutoService produtoService;
    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> listarTodos() {
        List<ProdutoEntity> lista = produtoService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> incluir(@RequestBody ProdutoEntity produto) {
        ProdutoEntity novo = produtoService.incluir(produto);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
     @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> editar(@PathVariable int id, @RequestBody ProdutoEntity produto) {
        ProdutoEntity atualizado = produtoService.editar(id,produto);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        produtoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
