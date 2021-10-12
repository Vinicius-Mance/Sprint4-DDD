package br.com.repository;

import br.com.beans.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

   List<Endereco> findAll();

//   <EnderecoMod extends Endereco>  EndrecoMod save(EnderecoMod endereco);
}
