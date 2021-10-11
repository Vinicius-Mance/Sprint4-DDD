package br.com.sprint4;

import br.com.beans.Endereco;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class Sprint4DddApplicationTests {

	@Test
	public void consumirAPI() {
		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("viacep.com.br")
				.path("ws/01538001/json")
				.build();

		ResponseEntity<Endereco> entity = template.getForEntity(uri.toUriString(), Endereco.class);

		System.out.println(entity.getBody().toString());
	}

}
