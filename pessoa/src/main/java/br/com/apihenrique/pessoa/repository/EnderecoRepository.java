package br.com.apihenrique.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apihenrique.pessoa.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
