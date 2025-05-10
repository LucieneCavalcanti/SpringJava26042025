package br.edu.fatecriopreto.projeto26042025.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecriopreto.projeto26042025.entities.CategoriaEntity;
import br.edu.fatecriopreto.projeto26042025.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class CategoriaService {

    @SuppressWarnings("unused")
    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaEntity incluir(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    public CategoriaEntity editar(int id,CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<CategoriaEntity> listarTodos() {
        return categoriaRepository.findAll();
    }
    public void excluir(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
