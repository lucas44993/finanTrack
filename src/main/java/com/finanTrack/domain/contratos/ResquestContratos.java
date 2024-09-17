package com.finanTrack.domain.contratos;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record ResquestContratos(


        Integer id,

        @CreationTimestamp
        @Column(nullable = false, updatable = false)
        LocalDateTime createdAt,

        @NotBlank
        String nome){
}
