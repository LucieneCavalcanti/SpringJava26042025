package br.edu.fatecriopreto.projeto26042025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecriopreto.projeto26042025.entities.ItensCompraEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //ao usar isso não precisa do @Autowired no objeto
public class ItensCompraService {

    @SuppressWarnings("unused")
    @Autowired
    private final ItensCompraEntity itensCompra;
}
