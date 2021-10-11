package br.com.ConsumoApi;

import br.com.beans.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


public class EnderecoApi {

    public static String consumirAPI() {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("viacep.com.br")
                .path("ws/01538001/json")
                .build();

        ResponseEntity<Endereco> entity = template.getForEntity(uri.toUriString(), Endereco.class);

        return entity.getBody().toString();

    }
}
