package br.edu.fatecriopreto.projeto26042025.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecriopreto.projeto26042025.entities.ItensCompraEntity;
import br.edu.fatecriopreto.projeto26042025.repository.ItensCompraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class ItensCompraService {

    @SuppressWarnings("unused")
    @Autowired
    private final ItensCompraRepository itensCompraRepository;

    public ItensCompraEntity incluir(ItensCompraEntity item) {
        return itensCompraRepository.save(item);
    }

    public ItensCompraEntity editar(int id,ItensCompraEntity item) {
        return itensCompraRepository.save(item);
    }

    public List<ItensCompraEntity> listarTodos() {
        return itensCompraRepository.findAll();
    }
    public void excluir(Integer id) {
        itensCompraRepository.deleteById(id);
    }
}
