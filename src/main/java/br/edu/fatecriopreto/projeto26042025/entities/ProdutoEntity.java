package br.edu.fatecriopreto.projeto26042025.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="tbprodutos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="descricao", length = 200, nullable = false)
    private String descricao;
    @Column
    private int estoque;
    @Column
    private float precoVenda;
    @Column
    private float precoCusto;
    
    @JoinColumn(name="idcategoria", nullable = false)
    private CategoriaEntity categoria;
}
