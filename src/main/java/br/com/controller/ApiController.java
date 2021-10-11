package br.com.controller;

import br.com.ConsumoApi.EnderecoApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/endereco")
    public String endereco() {
        return EnderecoApi.consumirAPI();
    }

}
