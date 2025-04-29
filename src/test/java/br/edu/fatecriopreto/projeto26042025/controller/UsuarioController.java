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

import br.edu.fatecriopreto.projeto26042025.entities.UsuarioEntity;
import br.edu.fatecriopreto.projeto26042025.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @SuppressWarnings("unused")
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listarTodos() {
        List<UsuarioEntity> lista = usuarioService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<UsuarioEntity> getUsuarioPorId(@PathVariable int id) {
    //     Optional<UsuarioEntity> user = usuarioService.buscarPorId(id);
    //     return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
    //             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }

    @PostMapping
    public ResponseEntity<UsuarioEntity> incluir(@RequestBody UsuarioEntity usuario) {
        UsuarioEntity novo = usuarioService.incluir(usuario);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> editar(@PathVariable int id, @RequestBody UsuarioEntity usuarioDetails) {
        UsuarioEntity atualizado = usuarioService.editar(id,usuarioDetails);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        usuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @GetMapping("/email/{email}")
    // public ResponseEntity<UsuarioEntity> getUsuarioPorEmail(@PathVariable String email) {
    //     Optional<UsuarioEntity> user = usuarioService.buscarPorEmail(email);
    //     return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
    //             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }

    // @PostMapping("/login")
    // public ResponseEntity<String> login(@RequestParam String email,
    //                                     @RequestParam String senha,
    //                                     HttpSession session) {

    //     String validação = usuarioService.validarUsuario(email, senha);
    //     if (validação.equals("Aprovado")) {
    //         session.setAttribute("user", email);
    //         return ResponseEntity.ok(email);
    //     } else if(validação.equals("Senha Incorreta")) {
    //         return new ResponseEntity<>("Senha Inválida", HttpStatus.UNAUTHORIZED);
    //     } else {
    //         return new ResponseEntity<>("Usuário Não Encontrado", HttpStatus.UNAUTHORIZED);
    //     }
    //}
}
