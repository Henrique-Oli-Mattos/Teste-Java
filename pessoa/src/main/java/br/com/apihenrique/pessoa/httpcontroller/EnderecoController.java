package br.com.apihenrique.pessoa.httpcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.apihenrique.pessoa.entity.Endereco;
import br.com.apihenrique.pessoa.service.EnderecoService;

@RestController
//Especificando a rota endereco
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    //Private ModelMapper modelMapper;

    //Post Mapping para requisição POST
    @PostMapping
    //Retorno de status de criado
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@RequestBody Endereco endereco){
        return enderecoService.salvar(endereco);
    }

    //Padrão de retorno de status já é OK
    @GetMapping
    public List<Endereco> listarEndereco(){
        return enderecoService.listarEndereco();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable("id") long id){
        return enderecoService.buscarEnderecoPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEndereco(@PathVariable("id") Long id){
        enderecoService.buscarEnderecoPorId(id).map(endereco ->{
            enderecoService.removerEndereco(id);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encntrado"));
    }

}
