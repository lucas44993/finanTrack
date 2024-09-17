package com.finanTrack.controllers;

import com.finanTrack.domain.contratos.Contratos;
import com.finanTrack.domain.contratos.ContratosRepository;
import com.finanTrack.domain.contratos.ResquestContratos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Contrato")
public class ContratoControler {

    @Autowired //injetar a dependencia automaticamente
    private ContratosRepository repository;

    @GetMapping // Para indicar que isso é um metedo GET HTTP ou puxar
    //Puxar todos os dados da tabela
    public ResponseEntity pegarDadosContrato() {
        var AllContratos = repository.findAll();
        return ResponseEntity.ok(AllContratos);
    }

    @PostMapping //para indicar que isso é um metedo Utilizado para criar novos recursos no servidor.
    public ResponseEntity adicionarContrato(@RequestBody @Valid ResquestContratos contrato ){
        Contratos novoContrato = new Contratos(contrato);
        System.out.println(contrato);
        repository.save(novoContrato);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity atualizarContrato(@RequestBody @Valid ResquestContratos contrato) {
        // Tente encontrar o contrato pelo ID
        Optional<Contratos> contratoExistente = repository.findById(contrato.id());

        if (contratoExistente.isPresent()) {
            Contratos atualizarContrato = contratoExistente.get();

            // Atualiza os campos necessários
            atualizarContrato.setNome(contrato.nome());

            // Salvando explicitamente, mas isso poderia ser gerenciado automaticamente pelo JPA
            repository.save(atualizarContrato);

            return ResponseEntity.ok(atualizarContrato);
        } else {
            // Se não encontrar, retorne uma resposta 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato não encontrado");
        }
    }

}
