package com.finanTrack.domain.metas;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.ResultSet;
import java.time.LocalDateTime;

@Entity(name = "metas")
@Table(name = "metas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Metas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double metas;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private Double contribuição;


    public Metas(RequestMetas requestMetas) {
        this.metas = requestMetas.metas();
        this.contribuição = requestMetas.contribuição();
    }
}
