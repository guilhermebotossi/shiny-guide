package br.com.ecommerce.product.mappers;

import java.util.Collection;
import java.util.Set;

import br.com.ecommerce.product.entities.Product;
import br.com.ecommerce.product.vos.ProductVO;

public interface ProductMapper {
	
	public ProductVO toProductVO(Product product);
	
	public Set<ProductVO> toProductVO(Collection<Product> product);

	public Product toProduct(ProductVO product);
	
	public Set<Product> toProduct(Collection<ProductVO> product);
}

