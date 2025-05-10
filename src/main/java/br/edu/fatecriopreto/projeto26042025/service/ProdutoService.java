package br.edu.fatecriopreto.projeto26042025.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecriopreto.projeto26042025.entities.ProdutoEntity;
import br.edu.fatecriopreto.projeto26042025.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class ProdutoService {

    @SuppressWarnings("unused")
    @Autowired
    private final ProdutoRepository produtoRepository;

    public ProdutoEntity incluir(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    public ProdutoEntity editar(int id,ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    public List<ProdutoEntity> listarTodos() {
        return produtoRepository.findAll();
    }
    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }
}
