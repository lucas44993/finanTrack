package com.finanTrack.controller;

import com.finanTrack.domain.empresas.Empresas;
import com.finanTrack.domain.empresas.RepositoryEmpresas;
import com.finanTrack.domain.empresas.RequestEmpresas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    private RepositoryEmpresas repositoryEmpresas;

    @GetMapping
    public ResponseEntity listarEmpresas() {
        var todasEmpresas = repositoryEmpresas.findAll();
        return ResponseEntity.ok(todasEmpresas);
    }

    @PostMapping
    public ResponseEntity inserirEmpresas(@RequestBody @Valid RequestEmpresas E){
        Empresas novaEmpresa = new Empresas(E);
        repositoryEmpresas.save(novaEmpresa);
        return ResponseEntity.ok().body("Empresa cadastrado com sucesso");
    }

    @PutMapping
    @Transactional
    public ResponseEntity editarEmpresas(@RequestBody @Valid RequestEmpresas E){
       Optional<Empresas> optionalEmpresas = repositoryEmpresas.findById(E.id());

        if (optionalEmpresas.isPresent()) {
            Empresas empresa = optionalEmpresas.get();
            empresa.setNome(E.nome());
            empresa.setCidade(E.cidade());
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirEmpresas(@PathVariable Integer id){
        repositoryEmpresas.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
