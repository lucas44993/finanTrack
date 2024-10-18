package com.finanTrack.controller;


import com.finanTrack.domain.contribuicao.Contribuicao;
import com.finanTrack.domain.contribuicao.RepositoryContribuicao;
import com.finanTrack.domain.contribuicao.RequestContribuicao;
import com.finanTrack.domain.empresas.Empresas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("contribuicao")
public class ContribuicaoController {

    @Autowired
    private RepositoryContribuicao repoContribuicao;

    @GetMapping
    public ResponseEntity listarContribuicao() {
        var todasContribuicaoes = repoContribuicao.findAll();
        return ResponseEntity.ok(todasContribuicaoes);
    }

    @PostMapping
    public ResponseEntity inserirContribuicao(@RequestBody @Valid RequestContribuicao c) {
        Contribuicao novaContribuicao = new Contribuicao(c);
        repoContribuicao.save(novaContribuicao);
        return ResponseEntity.ok().body("contribuição cadastrado com sucesso");
    }

    @PutMapping
    @Transactional
    public  ResponseEntity editarContribuicao(@RequestBody @Valid RequestContribuicao c) {
        Optional<Contribuicao> optionalContribuicao = repoContribuicao.findById(c.id());

        if (optionalContribuicao.isPresent()) {
            Contribuicao atuacontribuicao = optionalContribuicao.get();
            atuacontribuicao.setContribuicao(c.contribuicao());
            return ResponseEntity.ok(atuacontribuicao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
