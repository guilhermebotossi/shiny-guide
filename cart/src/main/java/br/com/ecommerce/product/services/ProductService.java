package br.com.ecommerce.product.services;

import java.util.Set;

import br.com.ecommerce.product.vos.ProductVO;

public interface ProductService {
	
	void delete(Long id);

	Set<ProductVO> findAll();

	ProductVO findById(Long id);

	void create(ProductVO product);

	void update(ProductVO product);

}
