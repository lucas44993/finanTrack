package com.finanTrack.domain.metas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestMetas(

        @NotBlank @NotNull
        Double metas,

        @NotBlank @NotNull
        Double contribuição

) {
}
