package br.edu.fatecriopreto.projeto26042025.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecriopreto.projeto26042025.entities.CompraEntity;
import br.edu.fatecriopreto.projeto26042025.repository.CompraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class CompraService {

    @SuppressWarnings("unused")
    @Autowired
    private final CompraRepository compraRepository;

    public CompraEntity incluir(CompraEntity usuario) {
        return compraRepository.save(usuario);
    }

    public CompraEntity editar(int id,CompraEntity usuario) {
        return compraRepository.save(usuario);
    }

    public List<CompraEntity> listarTodos() {
        return compraRepository.findAll();
    }
    public void excluir(Integer id) {
        compraRepository.deleteById(id);
    }
}
