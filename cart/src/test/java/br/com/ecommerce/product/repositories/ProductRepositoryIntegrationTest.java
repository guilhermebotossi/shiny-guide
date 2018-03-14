package br.com.ecommerce.product.repositories;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.product.model.Product;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DefaultProductRepository.class})
@EnableAutoConfiguration
@DataJpaTest
@Transactional
@EntityScan(basePackages = "br.com.ecommerce.product")
public class ProductRepositoryIntegrationTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void findAll_called_success() {
		List<Product> lp = productRepository.findAll();
		
		assertNotNull(lp);
		assertThat(lp, is(not(empty())));
		assertThat(lp, hasSize(5));
	}
	
	
	@Test
	public void findById_called_success() {
		Product p = productRepository.findById(2L);
		
		assertNotNull(p);
		assertEquals(Long.valueOf(2L), p.getId());
		assertEquals("Celular", p.getName());
		assertEquals(Double.valueOf("3595.50"), p.getValue());
	}
	
	@Test
	public void save_called_success() {
		Product p = new Product	();
		p.setId(10L);
		p.setName("Teclado");
		p.setValue(50.5);
		
		productRepository.save(p);
		
		Product p1 = productRepository.findById(10L);
		assertNotNull(p1);
		assertEquals(Long.valueOf(10L), p1.getId());
		assertEquals("Teclado", p1.getName());
		assertEquals(Double.valueOf(50.5), p1.getValue());
	}
	
	@Test
	public void update_called_success() {
		Product p = new Product	();
		p.setId(3L);
		p.setName("Mouse");
		p.setValue(150.5);
		
		productRepository.update(p);
		
		Product p1 = productRepository.findById(3L);
		assertNotNull(p1);
		assertEquals(Long.valueOf(3L), p1.getId());
		assertEquals("Mouse", p1.getName());
		assertEquals(Double.valueOf(150.5), p1.getValue());
	}
	
	@Test(expected = RuntimeException.class)
	public void update_called_throws() {
		Product p = new Product	();
		p.setId(300L);
		p.setName("Mouse");
		p.setValue(150.5);
		
		productRepository.update(p);
	}
	
	@Test
	public void delete_called_success() {
		productRepository.delete(1L);
		
		List<Product> lp = productRepository.findAll();
		
		assertNotNull(lp);
		assertThat(lp, is(not(empty())));
		assertThat(lp, hasSize(4));
		assertTrue(lp.stream().filter(p -> p.getId() == 1L).count()== 0);
	}
	
	@Test(expected = RuntimeException.class)
	public void delete_called_throws() {
		productRepository.delete(100L);
	}
}
