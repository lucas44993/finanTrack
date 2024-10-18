package com.finanTrack.domain.metas;


import jakarta.validation.constraints.NotNull;

public record RequestMetas(

        Integer id,

        @NotNull
        Double meta,
        @NotNull
        Integer fabrica_id

) {
}
