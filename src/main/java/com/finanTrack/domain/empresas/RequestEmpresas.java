package com.finanTrack.domain.empresas;

import com.finanTrack.domain.rotas.Rotas;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record RequestEmpresas(

        Integer id,

        @NotBlank @NotNull
        String nome,

        @NotBlank @NotNull
        String cidade ,

        @NotNull
        Integer rota_id

) {
}
