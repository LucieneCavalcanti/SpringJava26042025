package br.edu.fatecriopreto.projeto26042025.entities;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="tbcompras")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    private float desconto;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    private float total;
    @OneToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    UsuarioEntity usuario;
}
