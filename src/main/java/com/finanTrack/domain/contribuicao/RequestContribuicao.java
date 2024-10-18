package com.finanTrack.domain.contribuicao;

import jakarta.validation.constraints.NotNull;

public record RequestContribuicao(Integer id, @NotNull Double contribuicao, Integer empresa_id, Integer fabrica_id, Integer metas_id) {
}
