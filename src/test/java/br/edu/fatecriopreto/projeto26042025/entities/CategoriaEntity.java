package br.edu.fatecriopreto.projeto26042025.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbcategorias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter    
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;  
}
