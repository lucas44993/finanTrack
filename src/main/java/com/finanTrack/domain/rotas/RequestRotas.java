package com.finanTrack.domain.rotas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestRotas(@NotNull @NotBlank String nome, Integer id) {
}
