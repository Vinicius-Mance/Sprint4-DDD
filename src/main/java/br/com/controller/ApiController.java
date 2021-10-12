package br.com.controller;

import br.com.ConsumoApi.EnderecoApi;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @RequestMapping(value="/endereco/{cep}", method = RequestMethod.GET)
    public String endereco(@PathVariable("cep") String cep) {
        
    }

}

}
