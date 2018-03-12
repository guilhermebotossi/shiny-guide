package br.com.ecommerce.cart.product.services;

import static br.com.ecommerce.cart.commons.ExtendedMockito.mockList;
import static br.com.ecommerce.cart.commons.ExtendedMockito.mockSet;
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

import br.com.ecommerce.cart.product.entities.Product;
import br.com.ecommerce.cart.product.mappers.ProductMapper;
import br.com.ecommerce.cart.product.repositories.ProductRepository;
import br.com.ecommerce.cart.product.vos.ProductVO;

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
	public void findAllComplete_called_sucess() {
		List<Product> list = mockList(Product.class);
		when(productRepository.findAllComplete()).thenReturn(list);
		
		Set<ProductVO> set = mockSet(ProductVO.class);
		when(productMapper.toProductVO(list)).thenReturn(set);
		
		Set<ProductVO> si = productService.findAllComplete();
		
		verify(productRepository).findAllComplete();
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
	public void findByIdComplete_called_sucess() {
		Long id = 1L;
		Product image = mock(Product.class);
		when(productRepository.findByIdComplete(id)).thenReturn(image);
		ProductVO vo1 = mock(ProductVO.class);
		when(productMapper.toProductVO(image)).thenReturn(vo1);
		
		
		ProductVO vo2 = productService.findByIdComplete(id);
		
		verify(productRepository).findByIdComplete(id);
		verify(productMapper).toProductVO(image);
		assertNotNull(vo2);
		assertSame(vo1, vo2);
	}
	
	@Test
	public void findSubproductsByParentId_called_sucess() {
		Long id = 1L;
		List<Product> list = mockList(Product.class);
		when(productRepository.findSubproductsByParentId(id)).thenReturn(list);
		
		Set<ProductVO> set = mockSet(ProductVO.class);
		when(productMapper.toProductVO(list)).thenReturn(set);
		
		
		Set<ProductVO> si = productService.findSubproductsByParentId(id);
		
		verify(productRepository).findSubproductsByParentId(id);
		verify(productMapper).toProductVO(list);
		assertNotNull(si);
		assertSame(set, si);
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
