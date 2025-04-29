package br.edu.fatecriopreto.projeto26042025.entities;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="tbcompras")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp datahora;
    private float desconto;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    private float total;
    @OneToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    UsuarioEntity usuario;
}
