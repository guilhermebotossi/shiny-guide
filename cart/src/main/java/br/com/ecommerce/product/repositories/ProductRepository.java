package br.com.ecommerce.product.repositories;

import java.util.List;

import br.com.ecommerce.product.model.Product;

public interface ProductRepository {

	List<Product> findAll();
	
	void save(Product entity);
	
	void update(Product product);

	Product findById(Long id);

	void delete(Long id);
	
	default Class<Product> getEntityClass() {
		return Product.class;
	}

}
