package br.com.ecommerce.cart.product.mappers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.ecommerce.cart.product.entities.Product;
import br.com.ecommerce.cart.product.vos.ProductVO;

@Service
public class DefaultProductMapper implements ProductMapper {
	
	@Override
	public ProductVO toProductVO(Product product) {
		checkProductBeforeMap(product);
		ProductVO vo = new ProductVO();
		vo.setId(product.getId());
		vo.setName(product.getName());
		vo.setValue(product.getValue());;
		
		return vo;
	}

	@Override
	public Product toProduct(ProductVO vo) {
		checkProductVOBeforeMap(vo);
		Product product = new Product();
		product.setId(vo.getId());
		product.setName(vo.getName());
		product.setValue(vo.getValue());
		
		return product;
	}
	
	private void checkProductBeforeMap(Product product) {
		String field = null;
		
		if(product == null) 
			field = "Product";
		
		else if(product.getId() == null)
			field = "Id";
		
		else if(product.getName() == null) 
			field = "Name";
		
		else if(product.getValue() == null) 
			field = "Value";
		
		if(field != null)
			throw new RuntimeException(String.format("The %s must not be null", field));
	}

	private void checkProductVOBeforeMap(ProductVO vo) {
		String field = null;
		
		if(vo == null) 
			field = "ProductVO";
		
		else if(vo.getId() == null)
			field = "Id";
		
		else if(vo.getName() == null) 
			field = "Name";
		
		else if(vo.getValue() == null) 
			field = "Value";
		
		if(field != null)
			throw new RuntimeException(String.format("The %s must not be null", field));
	}

	@Override
	public Set<ProductVO> toProductVO(Collection<Product> products) {
		Set<ProductVO> pvol = new HashSet<>();
		
		products.forEach(prod -> {
			pvol.add(toProductVO(prod));
		});
		return pvol;
	}

	@Override
	public Set<Product> toProduct(Collection<ProductVO> products) {
		Set<Product> pl = new HashSet<>();
		
		products.forEach(prod -> {
			pl.add(toProduct(prod));
		});
		return pl;
	}

}
