package br.com.ecommerce.product.mappers;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ecommerce.product.model.Product;
import br.com.ecommerce.product.vos.ProductVO;

@RunWith(SpringRunner.class)
@WebMvcTest(DefaultProductMapper.class)
public class ProductMapperTest {

	@Autowired
	private ProductMapper productMapper;

	@Test
	public void toImage_calledWithVONull_throws() {
		RuntimeException re = null;
		ProductVO vo = null;

		try {
			productMapper.toProduct(vo);
		} catch (RuntimeException e) {
			re = e;
		}

		assertNotNull(re);
		assertEquals("The ProductVO must not be null", re.getMessage());
	}

	@Test
	public void toImage_calledWithIdNull_throws() {
		RuntimeException re = null;
		ProductVO vo = new ProductVO();

		try {
			productMapper.toProduct(vo);
		} catch (RuntimeException e) {
			re = e;
		}

		assertNotNull(re);
		assertEquals("The Id must not be null", re.getMessage());
	}

	@Test
	public void toImage_calledWithNameNull_throws() {
		RuntimeException re = null;
		ProductVO vo = new ProductVO();
		vo.setId(1L);

		try {
			productMapper.toProduct(vo);
		} catch (RuntimeException e) {
			re = e;
		}

		assertNotNull(re);
		assertEquals("The Name must not be null", re.getMessage());
	}

	@Test
	public void toImage_calledWithDescNull_throws() {
		RuntimeException re = null;
		ProductVO vo = new ProductVO();
		vo.setId(1L);
		vo.setName("Product");

		try {
			productMapper.toProduct(vo);
		} catch (RuntimeException e) {
			re = e;
		}

		assertNotNull(re);
		assertEquals("The Value must not be null", re.getMessage());
	}

	@Test
	public void toImage_called_sucess() {
		ProductVO vo = new ProductVO();
		vo.setId(1L);
		vo.setName("Product");
		vo.setValue(10.5);

		Product product = productMapper.toProduct(vo);

		assertNotNull(product);
		assertEquals(Long.valueOf(1L), product.getId());
		assertEquals("Product", product.getName());
		assertEquals(Double.valueOf(10.5), product.getValue());
	}
	
	
	@Test
	public void toImageVO_calledWithVONull_throws() {
		RuntimeException re = null;
		Product product = null;

		try {
			productMapper.toProductVO(product);
		} catch (RuntimeException e) {
			re = e;  
		}

		assertNotNull(re);
		assertEquals("The Product must not be null", re.getMessage());
	}

	@Test
	public void toImageVO_calledWithIdNull_throws() {
		RuntimeException re = null;
		Product product = new Product();

		try {
			productMapper.toProductVO(product);
		} catch (RuntimeException e) {
			re = e;
		}

		assertNotNull(re);
		assertEquals("The Id must not be null", re.getMessage());
	}

	@Test
	public void toImageVO_calledWithNameNull_throws() {
		RuntimeException re = null;
		Product product = new Product();
		product.setId(1L);

		try {
			productMapper.toProductVO(product);
		} catch (RuntimeException e) {
			re = e;
		}

		assertNotNull(re);
		assertEquals("The Name must not be null", re.getMessage());
	}

	@Test
	public void toImageVO_calledWithDescNull_throws() {
		RuntimeException re = null;
		Product product = new Product();
		product.setId(1L);
		product.setName("Product");

		try {
			productMapper.toProductVO(product);
		} catch (RuntimeException e) {
			re = e;
		}

		assertNotNull(re);
		assertEquals("The Value must not be null", re.getMessage());
	}
	
	
	@Test
	public void toImageVO_called_sucess() {
		Product product = new Product();
		product.setId(1L);
		product.setName("Product");
		product.setValue(10.5);

		ProductVO vo = productMapper.toProductVO(product);

		assertNotNull(product);
		assertEquals(Long.valueOf(1L), vo.getId());
		assertEquals("Product", vo.getName());
		assertEquals(Double.valueOf(10.5), vo.getValue());
	}

	

	
	@Test
	public void toImage_calledWithList_success() { 
		List<ProductVO> list = new ArrayList<>();
		
		ProductVO vo = new ProductVO();
		vo.setId(1L);
		vo.setName("Product");
		vo.setValue(10.5);
		
		list.add(vo);
		
		
		Set<Product> set = productMapper.toProduct(list);
		
		assertNotNull(set);
		assertThat(set, is(not(empty())));
		assertThat(set, hasSize(1));
		Product product = set.iterator().next();
		assertEquals(Long.valueOf(1L), product.getId());
		assertEquals("Product", product.getName());
		assertEquals(Double.valueOf(10.5), product.getValue());
	}
	
	@Test
	public void toImageVO_calledWithList_success() { 
		List<Product> list = new ArrayList<>();
		
		Product product = new Product();
		product.setId(1L);
		product.setName("Product");
		product.setValue(10.5);
		
		list.add(product);
		
		
		Set<ProductVO> set = productMapper.toProductVO(list);
		
		assertNotNull(set);
		assertThat(set, is(not(empty())));
		assertThat(set, hasSize(1));
		ProductVO vo = set.iterator().next();
		assertEquals(Long.valueOf(1L), vo.getId());
		assertEquals("Product", vo.getName());
		assertEquals(Double.valueOf(10.5), vo.getValue());
	}
}
