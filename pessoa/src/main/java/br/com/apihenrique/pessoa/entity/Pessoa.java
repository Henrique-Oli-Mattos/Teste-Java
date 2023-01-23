package br.com.apihenrique.pessoa.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Utilizando Lombok para manter o código mais limpo
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pessoa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "dataNasc", nullable = false)
    private String dataNasc;

    @JsonManagedReference
    @OneToMany(mappedBy = "pessoa")
    List<Endereco> enderecos;

}
