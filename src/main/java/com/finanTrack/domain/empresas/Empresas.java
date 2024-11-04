package com.finanTrack.domain.empresas;

import com.finanTrack.domain.rotas.Rotas;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

// Faz com que o spring Identifique que isso é uma entidade e uma tabela.
@Entity(name = "Empresas")
@Table (name = "Empresas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresas {

    //Id da tabela e que vai ser gerado automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cidade;

    //fazer o relacionamento disso depois.

    @JoinColumn(name = "rota_id", nullable = false)
    private Integer rota_id;

    public Empresas (RequestEmpresas R){
        this.nome = R.nome();
        this.cidade = R.cidade();
        this.rota_id = R.rota_id();
    }
}
