package br.com.ConsumoApi;

import br.com.beans.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


public class EnderecoApi {

    public static String consumirAPI(String cep) {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("viacep.com.br")
                .path("ws/" + cep + "/json")
                .build();
        if (cep.length() == 8) {
            ResponseEntity<Endereco> entity = template.getForEntity(uri.toUriString(), Endereco.class);
            if (!entity.getBody().isErro()) {
                
                return entity.getBody().toString();
            }
        }
        return "deu ruim";
    }
}

