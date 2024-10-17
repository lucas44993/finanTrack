package com.finanTrack.domain.fabricas;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "fabricas")
@Table(name = "fabricas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fabricas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    //@Column(name = "created_at", nullable = false, updatable = false) // Não pode me retornar nullo e nem ser atualizado
    //@Column(nullable = true, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //erá preenchido automaticamente pelo banco de dados como a data/hora atual no momento da inserção, devido à definição SQL DEFAULT CURRENT_TIMESTAMP.
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


    //isso vai ser criado pelo o banco de dados depois buscar a anotação certa
    private String createAt;


    public Fabricas(RequestFabricas requestFabricas){
        this.nome = requestFabricas.nome();
    }
}
