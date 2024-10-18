package com.finanTrack.domain.rotas;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "rotas")
@Entity(name = "rotas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Rotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;


    public Rotas(@Valid RequestRotas R){
        this.nome = R.nome();
    }
}
