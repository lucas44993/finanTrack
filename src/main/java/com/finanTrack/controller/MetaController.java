package com.finanTrack.controller;

import com.finanTrack.domain.fabricas.Fabricas;
import com.finanTrack.domain.metas.Metas;
import com.finanTrack.domain.metas.RepositoryMetas;
import com.finanTrack.domain.metas.RequestMetas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("metas")
public class MetaController {

    @Autowired
    private RepositoryMetas repoMetas;

    @GetMapping
    public ResponseEntity listarMetas(){
        var todasMetas = repoMetas.findAll();
        return ResponseEntity.ok(todasMetas);
    }

    @PostMapping
    public ResponseEntity adicionarMetas(@RequestBody RequestMetas M){
        Metas novaMeta = new Metas(M);
        repoMetas.save(novaMeta);
        return ResponseEntity.ok().body("meta criada com sucesso");
    }

    @PutMapping
    @Transactional
    public ResponseEntity editarMetas(@RequestBody @Valid RequestMetas M){
        Optional<Metas> optionalMetas = repoMetas.findById(M.id());

        if(optionalMetas.isPresent()){
            Metas meta = optionalMetas.get();
            meta.setMeta(M.meta());
            meta.setFabrica_id(M.fabrica_id());
            return ResponseEntity.ok(meta);
        }else{
            return ResponseEntity.notFound().build();}
    }
}
