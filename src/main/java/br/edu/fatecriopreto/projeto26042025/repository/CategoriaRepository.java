package br.edu.fatecriopreto.projeto26042025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecriopreto.projeto26042025.entities.CategoriaEntity;

@Repository
public interface CategoriaRepository
 extends JpaRepository<CategoriaEntity, Integer>{

}
