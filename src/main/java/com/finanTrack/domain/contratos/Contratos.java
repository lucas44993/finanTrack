package com.finanTrack.domain.contratos;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "contratos") //Representa a tabela.
@Entity(name = "contratos") //representa a entidade que é a tabela.
@EqualsAndHashCode(of = "id") //quando você tem um campo que é um identificador único.
@Getter //Gera automaticamente metodos getters.
@Setter //Gera automaticamente metodos setter.
@AllArgsConstructor //Gera os construtor com todos os parametros da classe.
@NoArgsConstructor //Gera um construtuor vazio.
public class Contratos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera automaticamente o valor de id por conta do banco de dados não sequencial
    private Integer id;

    private String nome;

    // @Column(name = "created_at", nullable = false, updatable = false) // Não pode me retornar nullo e nem ser atualizado
    // @Column(nullable = true, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //erá preenchido automaticamente pelo banco de dados como a data/hora atual no momento da inserção, devido à definição SQL DEFAULT CURRENT_TIMESTAMP.
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


    public Contratos (ResquestContratos resquestContratos){
      this.nome = resquestContratos.nome();
    }


}
