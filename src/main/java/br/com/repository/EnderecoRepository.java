package br.com.repository;

import br.com.beans.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{

    List<Endereco> findAll();


    Endereco findByCodigo (int codigo);


    void delete(Endereco endereco);

    <EnderecoMod extends Endereco>  EnderecoMod save(EnderecoMod endereco);
}
