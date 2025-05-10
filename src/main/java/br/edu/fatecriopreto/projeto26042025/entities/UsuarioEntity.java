package br.edu.fatecriopreto.projeto26042025.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

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
@Table(name="tbusuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nomeusuario", length = 200, nullable = false)
    private String nome;
    @Column(name="senhausuario", length = 20, nullable = false)
    private String senha;
    @Column(name = "emailusuario", length = 200, nullable = false)
    private String email;
    @JoinColumn(name="idstatus", nullable = false)
    @OneToOne
    private StatusEntity status;
    //ou @Column(columnDefinition = "timestamp default current_timestamp")
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
         //https://www.w3docs.com/snippets/java/setting-default-values-for-columns-in-jpa.html
         //https://www.baeldung.com/jpa-default-column-values
}
