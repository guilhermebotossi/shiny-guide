package br.com.ecommerce.product.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.product.mappers.ProductMapper;
import br.com.ecommerce.product.model.Product;
import br.com.ecommerce.product.repositories.ProductRepository;
import br.com.ecommerce.product.vos.ProductVO;

@Service
public class DefaultProductService implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
    @Autowired
    private ProductMapper productMapper;
	
	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

	@Override
	public Set<ProductVO> findAll() {
		return productMapper.toProductVO(productRepository.findAll());
	}
	
	@Override
	public ProductVO findById(Long id) {
		return productMapper.toProductVO(productRepository.findById(id));
	}

	@Override
	public void create(ProductVO vo) {
		Product product = productMapper.toProduct(vo);
		productRepository.save(product);
	}

	@Override
	public void update(ProductVO vo) {
		Product product = productMapper.toProduct(vo);
		productRepository.update(product);
	}

}
