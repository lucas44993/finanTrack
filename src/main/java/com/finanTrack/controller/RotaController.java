package com.finanTrack.controller;


import com.finanTrack.domain.empresas.Empresas;
import com.finanTrack.domain.empresas.RequestEmpresas;
import com.finanTrack.domain.rotas.RepositoryRotas;
import com.finanTrack.domain.rotas.RequestRotas;
import com.finanTrack.domain.rotas.Rotas;
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
    private RepositoryRotas repositoryRotas;

    @GetMapping
    public ResponseEntity listarRotas(){
        var listaRotas = repositoryRotas.findAll();
        return ResponseEntity.ok(listaRotas);
    }

    @PostMapping
    public ResponseEntity inserirRotas(@RequestBody @Valid RequestRotas R){
        Rotas novaRota = new Rotas(R);
        repositoryRotas.save(novaRota);
        return ResponseEntity.ok().body("Rota criada com sucesso");
    }
    @PutMapping
    @Transactional
    public ResponseEntity editarRotas(@RequestBody @Valid RequestRotas R){
        Optional<Rotas> optionalRotas = repositoryRotas.findById(R.id());

        if (optionalRotas.isPresent()) {
            Rotas rota = optionalRotas.get();
            rota.setNome(R.nome());
            return ResponseEntity.ok(rota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirEmpresas(@PathVariable Integer id){
        repositoryRotas.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
