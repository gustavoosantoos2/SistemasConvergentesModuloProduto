package br.edu.positivo.scpe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.positivo.scpe.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	@Query("select p from Product p where p.description = ?1")
	Product findByDescription(String description);
}
