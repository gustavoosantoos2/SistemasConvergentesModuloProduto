package br.edu.positivo.scpe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.positivo.scpe.entity.IProductService;
import br.edu.positivo.scpe.entity.Product;
import br.edu.positivo.scpe.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		repository.findAll().forEach(e -> products.add(e));
		
		return products;
	}

	@Override
	public Product getProductById(int id) {
		return repository.findById(new Integer(id)).orElse(null);
	}

	@Override
	public Product getProductByDescription(String description) {
		return repository.findByDescription(description);
	}
	
	@Override
	public boolean addProduct(Product product) {
		Product productsWithSameDescription = repository.findByDescription(product.getDescription());
		if (productsWithSameDescription != null)
			return false;
		
		repository.save(product);
		return true;
	}

	@Override
	public void updateProduct(Product product) {
		boolean productExists = repository.findById(product.getId()) != null;
		if (productExists) {
			repository.save(product);
		}
	}

	@Override
	public void deleteProduct(Product product) {
		boolean productExists = repository.findById(product.getId()) != null;
		if (productExists) {
			repository.delete(product);
		}
	}
	
}
