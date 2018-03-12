package br.com.ecommerce.cart.product.repositories;

import java.util.List;

import br.com.ecommerce.cart.product.entities.Product;

public interface ProductRepository {

	List<Product> findAll();
	
	List<Product> findAllComplete();

	void save(Product entity);
	
	void update(Product product);

	Product findById(Long id);

	void delete(Long id);
	
	Product findByIdComplete(Long id);
	
	List<Product> findSubproductsByParentId(Long id);
	
	default Class<Product> getEntityClass() {
		return Product.class;
	}

}
