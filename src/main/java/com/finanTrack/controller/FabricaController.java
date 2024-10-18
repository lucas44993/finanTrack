package com.finanTrack.controller;


import com.finanTrack.domain.fabricas.Fabricas;
import com.finanTrack.domain.fabricas.RepositoryFabricas;
import com.finanTrack.domain.fabricas.RequestFabricas;
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
    private RepositoryFabricas repositoryFabricas;

    @GetMapping
    public ResponseEntity listarFabricas(){
        var todasFabricas = repositoryFabricas.findAll();
        return ResponseEntity.ok(todasFabricas);
    }

    @PostMapping
    public ResponseEntity inserirFabrica(@RequestBody @Valid RequestFabricas RF){
        Fabricas novaFabrica = new Fabricas(RF);
        repositoryFabricas.save(novaFabrica);
        return ResponseEntity.ok().body("fabrica criada com sucesso");
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarFabrica(@RequestBody @Valid RequestFabricas RF){
        Optional<Fabricas> optionalFabricas = repositoryFabricas.findById(RF.id());

        if(optionalFabricas.isPresent()){
            Fabricas fabrica = optionalFabricas.get();
            fabrica.setNome(RF.nome());
            return ResponseEntity.ok(fabrica);
        }else{
        return ResponseEntity.notFound().build();}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluirFabrica(@PathVariable Integer id){
        repositoryFabricas.deleteById(id);
        return ResponseEntity.ok().build();
    }
}