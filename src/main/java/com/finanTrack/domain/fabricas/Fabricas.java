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

    @CreationTimestamp
    private LocalDateTime create_at;



    public Fabricas(RequestFabricas requestFabricas){
        this.nome = requestFabricas.nome();
    }
}
