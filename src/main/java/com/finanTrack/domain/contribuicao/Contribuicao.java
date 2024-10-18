package com.finanTrack.domain.contribuicao;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "contribuicao")
@Table(name = "contribuicao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double contribuicao;
    private Integer empresa_id;
    private Integer fabrica_id;
    private Integer metas_id;

    public Contribuicao(RequestContribuicao requestContribuicao){
        this.contribuicao = requestContribuicao.contribuicao();
        this.empresa_id = requestContribuicao.empresa_id();
        this.fabrica_id = requestContribuicao.fabrica_id();
        this.metas_id = requestContribuicao.metas_id();
    }
}
