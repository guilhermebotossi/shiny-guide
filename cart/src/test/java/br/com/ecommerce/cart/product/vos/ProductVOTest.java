package br.com.ecommerce.cart.product.vos;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class ProductVOTest {


	private ProductVO vo;

	@Before
	public void init() {
		vo = new ProductVO();
	}

	@Test
	public void idTest() {
		Long id = 1L;

		vo.setId(id);

		assertSame(id, vo.getId());
	}

	@Test
	public void nameTest() {
		String name = "Product 1";

		vo.setName(name);

		assertSame(name, vo.getName());
	}
	
	@Test
	public void valueTest() {
		Double value = 10.5;

		vo.setValue(value);

		assertSame(value, vo.getValue());
	}

}
