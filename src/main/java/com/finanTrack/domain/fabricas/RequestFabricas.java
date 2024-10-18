package com.finanTrack.domain.fabricas;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record RequestFabricas(

        Integer id,

        @NotBlank @NotNull
        String nome,

        @CreationTimestamp
        LocalDateTime create_at

) {
}
