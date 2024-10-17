package com.finanTrack.domain.rotas;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "rotas")
@Entity(name = "rotas")
@EqualsAndHashCode(of = "id")
public class Rotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
