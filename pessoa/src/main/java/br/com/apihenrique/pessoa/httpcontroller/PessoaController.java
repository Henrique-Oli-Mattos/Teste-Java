package br.com.apihenrique.pessoa.httpcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.apihenrique.pessoa.entity.Pessoa;
import br.com.apihenrique.pessoa.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    //Retorno de status de criado
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoa(){
        return pessoaService.listarPessoa();
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable("id") long id){
        return pessoaService.buscarPessoaPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPessoa(@PathVariable("id") Long id){
        pessoaService.buscarPessoaPorId(id).map(pessoa ->{
            pessoaService.removerPessoa(id);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encntrada"));
    }

    @PutMapping("/{id}")
    public void atualizarPessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa){
        pessoaService.buscarPessoaPorId(id).map(pessoaMap ->{
            pessoaService.atualizar(pessoa);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encntrada"));
    }

}
