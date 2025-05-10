package br.edu.fatecriopreto.projeto26042025.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecriopreto.projeto26042025.entities.UsuarioEntity;
import br.edu.fatecriopreto.projeto26042025.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class UsuarioService {

    @SuppressWarnings("unused")
    @Autowired
    private final UsuarioRepository usuarioRepository;

        public UsuarioEntity incluir(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity editar(int id, UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> listarTodos() {
        return usuarioRepository.findAll();
    }
    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
