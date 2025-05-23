package br.edu.fatecriopreto.projeto26042025.service;

import java.util.List;
import java.util.Optional;

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

    // public CategoriaEntity editar(int id,CategoriaEntity categoria) {
    //     return categoriaRepository.save(categoria);
    // }
    public CategoriaEntity editar(int id, CategoriaEntity categoria) {
        // Verifique se a categoria existe
        Optional<CategoriaEntity> categoriaExistente = categoriaRepository.findById(id);
        
        if (categoriaExistente.isPresent()) {
            // Atualiza a categoria
            CategoriaEntity categoriaAtualizada = categoriaExistente.get();
            categoriaAtualizada.setDescricao(categoria.getDescricao());  // Atualiza os campos necessários
            return categoriaRepository.save(categoriaAtualizada);  // Salva a categoria atualizada
        } else {
            // Caso a categoria não exista, retorna null
            return null;
        }
    }

    public List<CategoriaEntity> listarTodos() {
        return categoriaRepository.findAll();
    }
    public void excluir(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
