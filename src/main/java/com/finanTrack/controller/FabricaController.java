package com.finanTrack.controller;


import com.finanTrack.domain.fabricas.Fabricas;
import com.finanTrack.domain.fabricas.RepositoryFabricas;
import com.finanTrack.domain.fabricas.RequestFabricas;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("fabrica")
public class FabricaController {

    @Autowired
    private RepositoryFabricas repoFabricas;

    @GetMapping
    public ResponseEntity listarFabricas(){
        var todasFabricas = repoFabricas.findAll();
        return ResponseEntity.ok(todasFabricas);
    }

    @PostMapping
    public ResponseEntity inserirFabrica(@RequestBody @Valid RequestFabricas RF){
        Fabricas novaFabrica = new Fabricas(RF);
        repoFabricas.save(novaFabrica);
        return ResponseEntity.ok().body("fabrica criada com sucesso");
    }

    @PutMapping
    @Transactional
    public ResponseEntity editarFabrica(@RequestBody @Valid RequestFabricas RF){
        Optional<Fabricas> optionalFabricas = repoFabricas.findById(RF.id());

        if(optionalFabricas.isPresent()){
            Fabricas fabrica = optionalFabricas.get();
            fabrica.setNome(RF.nome());
            return ResponseEntity.ok(fabrica);
        }else{
            throw new EntityNotFoundException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluirFabrica(@PathVariable Integer id){
        repoFabricas.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
