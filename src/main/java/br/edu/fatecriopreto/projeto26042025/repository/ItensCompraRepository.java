package br.edu.fatecriopreto.projeto26042025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecriopreto.projeto26042025.entities.ItensCompraEntity;

@Repository
public interface ItensCompraRepository extends JpaRepository<ItensCompraEntity, Integer>{

}
