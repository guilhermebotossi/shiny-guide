package br.com.ecommerce.product.services;

import static br.com.ecommerce.commons.ExtendedMockito.mockList;
import static br.com.ecommerce.commons.ExtendedMockito.mockSet;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ecommerce.product.entities.Product;
import br.com.ecommerce.product.mappers.ProductMapper;
import br.com.ecommerce.product.repositories.ProductRepository;
import br.com.ecommerce.product.vos.ProductVO;

@RunWith(SpringRunner.class)
@WebMvcTest(DefaultProductService.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@MockBean
	private ProductMapper productMapper;
	
	@Test
	public void delete_called_sucess() {
		Long id = 1L;
		
		productService.delete(id);
		
		verify(productRepository).delete(id);
	}
	
	
	@Test
	public void findAll_called_sucess() {
		List<Product> list = mockList(Product.class);
		when(productRepository.findAll()).thenReturn(list);
		
		Set<ProductVO> set = mockSet(ProductVO.class);
		when(productMapper.toProductVO(list)).thenReturn(set);
		
		Set<ProductVO> si = productService.findAll();
		
		verify(productRepository).findAll();
		verify(productMapper).toProductVO(list);
		assertNotNull(si);
		assertSame(set, si);
	}

	
	@Test
	public void findById_called_sucess() {
		Long id = 1L;
		Product image = mock(Product.class);
		when(productRepository.findById(id)).thenReturn(image);
		ProductVO vo1 = mock(ProductVO.class);
		when(productMapper.toProductVO(image)).thenReturn(vo1);
		
		
		ProductVO vo2 = productService.findById(id);
		
		verify(productRepository).findById(id);
		verify(productMapper).toProductVO(image);
		assertNotNull(vo2);
		assertSame(vo1, vo2);
	}
	
	
	
	@Test
	public void create_called_sucess() {
		ProductVO vo = mock(ProductVO.class);
		Product image = mock(Product.class);
		when(productMapper.toProduct(vo)).thenReturn(image);
		
		productService.create(vo);
		
		verify(productMapper).toProduct(vo);
		verify(productRepository).save(image);
	}
	
	
	@Test
	public void update_called_sucess() {
		ProductVO vo = mock(ProductVO.class);
		Product image = mock(Product.class);
		when(productMapper.toProduct(vo)).thenReturn(image);
		
		productService.update(vo);
		
		verify(productMapper).toProduct(vo);
		verify(productRepository).update(image);
	}
}
