package br.com.apihenrique.pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apihenrique.pessoa.entity.Endereco;
import br.com.apihenrique.pessoa.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    //Salva e atualiza Endereco
    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEndereco(){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEnderecoPorId(Long id){
        return enderecoRepository.findById(id);
    }

    public void removerEndereco(Long id){
        enderecoRepository.deleteById(id);
    }
    
}
