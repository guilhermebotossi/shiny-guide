package br.com.ecommerce.cart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.ecommerce.product.model.Product;

@SuppressWarnings("unlikely-arg-type")
public class ShoppingCartItemTest {

	private ShoppingCartItem shoppingCartItem;

	@Before
	public void init() {
		shoppingCartItem = new ShoppingCartItem();
	}
	
	@Test
	public void productTest() {
		Product p = new Product();
		
		shoppingCartItem.setProduct(p);
		
		assertSame(p, shoppingCartItem.getProduct());
	}
	
	@Test
	public void quantityTest() {
		int quantity = 10;
		
		shoppingCartItem.setQuantity(quantity);
		
		assertEquals(Integer.valueOf(10), Integer.valueOf(shoppingCartItem.getQuantity()));
	}
	
	
	@Test
	public void hashcodeTest() {
		Product p = new Product();
		p.setId(1L);
		p.setName("prod1");
		
		shoppingCartItem.setProduct(p);
		
		int hashCode = shoppingCartItem.hashCode();
		
		assertEquals(Integer.valueOf(106943322), Integer.valueOf(hashCode));
	}
	
	public void hashcodeTest1() {
		
		int hashCode = shoppingCartItem.hashCode();
		
		assertEquals(Integer.valueOf(31), Integer.valueOf(hashCode));
	}
	
	@Test
	public void calculateTotalPriceTest() {
		Product p = new Product();
		p.setValue(10.0);
		
		shoppingCartItem.setProduct(p);
		shoppingCartItem.setQuantity(2);
		
		assertEquals(Double.valueOf(20.0), Double.valueOf(shoppingCartItem.calculateTotalPrice()));
	}
	
	@Test
	public void constructorTest() {
		Product p = new Product();
		int quantity = 10;
		
		shoppingCartItem = new ShoppingCartItem(p, quantity);
		
		assertSame(p, shoppingCartItem.getProduct());
		assertEquals(Integer.valueOf(10), Integer.valueOf(shoppingCartItem.getQuantity()));
	}
	
	
	@Test
	public void equalsTest() {
		assertTrue(shoppingCartItem.equals(shoppingCartItem));
	}
	
	@Test
	public void equalsTest1() {
		assertFalse(shoppingCartItem.equals(null));
	}
	
	@Test
	public void equalsTest2() {
		assertFalse(shoppingCartItem.equals("Teste"));
	}
	
	@Test
	public void equalsTest3() {
		ShoppingCartItem sci = new ShoppingCartItem();
		assertEquals(shoppingCartItem ,sci);
	}
	
	@Test
	public void equalsTest4() {
		ShoppingCartItem sci = new ShoppingCartItem();
		sci.setProduct(new Product());
		assertNotEquals(shoppingCartItem ,sci);
	}
	
	@Test
	public void equalsTest5() {
		ShoppingCartItem sci = new ShoppingCartItem();
		Product p1 = new Product();
		p1.setId(1L);
		sci.setProduct(p1);
		
		Product p2 = new Product();
		p2.setId(2L);
		shoppingCartItem.setProduct(p2);
		assertNotEquals(shoppingCartItem ,sci);
	}
}
