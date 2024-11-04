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

    private Double meta;

    @CreationTimestamp
    private LocalDateTime create_at;


    private Integer fabrica_id;


    public Metas(RequestMetas requestMetas) {
        this.meta = requestMetas.meta();
        this.fabrica_id =  requestMetas.fabrica_id();
    }
}
