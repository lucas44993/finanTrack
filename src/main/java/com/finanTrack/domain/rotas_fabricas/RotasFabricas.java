package com.finanTrack.domain.rotas_fabricas;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity(name = "rotasFabricas")
@Table(name = "rotasFabricas")
@EqualsAndHashCode(of = "id")
public class RotasFabricas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
