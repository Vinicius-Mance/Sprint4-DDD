package br.com.controller;

import br.com.beans.Endereco;
import br.com.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @RequestMapping(value="/endereco/{cep}", method = RequestMethod.GET)
    public String endereco(@PathVariable("cep") String cep) {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("viacep.com.br")
                .path("ws/" + cep + "/json")
                .build();
        if (cep.length() == 8) {
            ResponseEntity<Endereco> entity = template.getForEntity(uri.toUriString(), Endereco.class);
            if (!entity.getBody().isErro()) {
                System.out.println(entity.getBody());
                return entity.getBody().toString();
            }
        }
        return "deu ruim";
    }

    @Autowired
    private EnderecoRepository cadastro;

    @CrossOrigin
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public @ResponseBody
    List<Endereco> listar() {
        return cadastro.findAll();
    }

}

