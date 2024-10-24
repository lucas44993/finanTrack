package com.finanTrack.controller;


import com.finanTrack.domain.rotas.RepositoryRotas;
import com.finanTrack.domain.rotas.RequestRotas;
import com.finanTrack.domain.rotas.Rotas;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rotas")
public class RotaController {

    @Autowired
    private RepositoryRotas repoRotas;

    @GetMapping
    public ResponseEntity listarRotas(){
        var listaRotas = repoRotas.findAll();
        return ResponseEntity.ok(listaRotas);
    }

    @PostMapping
    public ResponseEntity inserirRotas(@RequestBody @Valid RequestRotas R){
        Rotas novaRota = new Rotas(R);
        repoRotas.save(novaRota);
        return ResponseEntity.ok().body("Rota criada com sucesso");
    }
    @PutMapping
    @Transactional
    public ResponseEntity editarRotas(@RequestBody @Valid RequestRotas R){
        Optional<Rotas> optionalRotas = repoRotas.findById(R.id());

        if (optionalRotas.isPresent()) {
            Rotas rota = optionalRotas.get();
            rota.setNome(R.nome());
            return ResponseEntity.ok(rota);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirEmpresas(@PathVariable Integer id){
        repoRotas.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
