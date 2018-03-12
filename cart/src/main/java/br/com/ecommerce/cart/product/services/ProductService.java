package br.com.ecommerce.cart.product.services;

import java.util.Set;

import br.com.ecommerce.cart.product.vos.ProductVO;

public interface ProductService {
	
	void delete(Long id);

	Set<ProductVO> findAll();
	
	Set<ProductVO> findAllComplete();

	ProductVO findById(Long id);

	void create(ProductVO product);

	void update(ProductVO product);

	ProductVO findByIdComplete(Long id);

	Set<ProductVO> findSubproductsByParentId(Long id);

}
