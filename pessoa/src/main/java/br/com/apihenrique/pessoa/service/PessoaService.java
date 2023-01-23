package br.com.apihenrique.pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apihenrique.pessoa.entity.Pessoa;
import br.com.apihenrique.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    //Salva e atualiza Pessoa
    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoa(){
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id){
        return pessoaRepository.findById(id);
    }

    public Pessoa atualizar(Pessoa pessoa){
        
        return pessoaRepository.save(pessoa);
        
    }

    public void removerPessoa(Long id){
        pessoaRepository.deleteById(id);
    }
}
