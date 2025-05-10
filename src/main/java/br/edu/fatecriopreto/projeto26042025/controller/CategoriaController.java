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

import br.edu.fatecriopreto.projeto26042025.entities.CategoriaEntity;
import br.edu.fatecriopreto.projeto26042025.service.CategoriaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @SuppressWarnings("unused")
    private final CategoriaService categoriaService;
        @GetMapping
    public ResponseEntity<List<CategoriaEntity>> listarTodos() {
        List<CategoriaEntity> lista = categoriaService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<CategoriaEntity> incluir(@RequestBody CategoriaEntity produto) {
        CategoriaEntity novo = categoriaService.incluir(produto);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
     @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> editar(@PathVariable int id, @RequestBody CategoriaEntity usuarioDetails) {
        CategoriaEntity atualizado = categoriaService.editar(id,usuarioDetails);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        categoriaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
