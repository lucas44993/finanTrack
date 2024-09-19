package com.finanTrack.domain.mêsPorContrato;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "MesPorContrato")
@Entity(name = "MesPorContrato")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MesPorContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double meta;
    private Double contribuicaoDaEmpresa;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public MesPorContrato(ResquestValores resquestValores){
        this.contribuicaoDaEmpresa = resquestValores.contribuicaoDaEmpresa();
        this.meta = resquestValores.meta();
    }
}
