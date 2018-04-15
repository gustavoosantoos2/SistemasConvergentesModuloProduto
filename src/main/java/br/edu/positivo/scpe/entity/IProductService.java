package br.edu.positivo.scpe.entity;

import java.util.List;

public interface IProductService {
	List<Product> getAllProducts();
	Product getProductById(int id);
	Product getProductByDescription(String description);
	boolean addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
