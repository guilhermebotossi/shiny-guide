
package br.com.ecommerce.product.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unlikely-arg-type")
public class ProductTest {

	private Product product;

	@Before
	public void init() {
		product = new Product();
	}

	@Test
	public void idTest() {
		Long id = 1L;

		product.setId(id);

		assertSame(id, product.getId());
	}

	@Test
	public void nameTest() {
		String name = "Product 1";

		product.setName(name);

		assertSame(name, product.getName());
	}
	
	@Test
	public void valueTest() {
		Double value = 10.5;

		product.setValue(value);

		assertSame(value, product.getValue());
	}
	
	@Test
	public void toStringTest() {
		product.setId(1L);
		product.setName("Celular");
		product.setValue(500.50);
		
		assertEquals("Product [id=1, name=Celular, value=500.5]", product.toString());
	}
	
	
	@Test
	public void hashCodeTest() {
		product.setId(1L);
		product.setName("Celular");
		
		assertEquals(Integer.valueOf(-1966884846), Integer.valueOf(product.hashCode()));
	}
	
	@Test
	public void equalsTest() {
		assertTrue(product.equals(product));
	}
	
	@Test
	public void equalsTest1() {
		assertFalse(product.equals(null));
	}
	
	
	@Test
	public void equalsTest2() {
		assertFalse(product.equals("Teste"));
	}
	
	@Test
	public void equalsTest3() {
		product.setId(1L);
		product.setName("Celular");
		
		Product p = new Product();
		p.setId(2L);
		p.setName("Tablet");
		
		assertFalse(product.equals(p));
	}

	
	@Test
	public void equalsTest4() {
		product.setId(1L);
		
		Product p = new Product();
		p.setId(1L);
		
		assertTrue(product.equals(p));
	}
	
	@Test
	public void equalsTest5() {
		product.setId(1L);
		product.setName("Celular");
		
		Product p = new Product();
		p.setId(1L);
		p.setName("Tablet");
		
		assertFalse(product.equals(p));
	}
}
