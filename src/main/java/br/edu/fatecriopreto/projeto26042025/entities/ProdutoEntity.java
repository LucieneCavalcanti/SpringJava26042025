package br.edu.fatecriopreto.projeto26042025.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
    
    @JoinColumn(name="idcategoria", referencedColumnName = "id")
    @OneToOne
    private CategoriaEntity categoria;
        private LocalDateTime dataCriacao;
         @PrePersist
         protected void onCreate() {
             this.dataCriacao = LocalDateTime.now();
         }
    private LocalDateTime ultimaAtualizacao;
         @PreUpdate
         protected void onUpdate() {
             this.ultimaAtualizacao = LocalDateTime.now();
         }
}
