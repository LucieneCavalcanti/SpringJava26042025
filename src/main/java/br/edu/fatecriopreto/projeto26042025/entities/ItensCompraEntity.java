package br.edu.fatecriopreto.projeto26042025.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbitenscompra")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter  
public class ItensCompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;   
    private int quantidade;
    private float valor;
    private float desconto;
    @OneToOne
    @JoinColumn(name = "idcompra", referencedColumnName = "id")
    CompraEntity compra;
    @OneToOne
    @JoinColumn(name = "idproduto", referencedColumnName = "id")
    ProdutoEntity produto;
}
