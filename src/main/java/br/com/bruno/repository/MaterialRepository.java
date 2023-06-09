package br.com.bruno.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.bruno.model.Material;

public interface MaterialRepository extends CrudRepository<Material,Long>{
    
}
