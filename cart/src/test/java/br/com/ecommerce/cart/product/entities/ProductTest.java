
package br.com.ecommerce.cart.product.entities;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

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

}
