package br.com.ecommerce.cart.model;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.ecommerce.product.model.Product;

public class ShoppingCartTest {

	private ShoppingCart shoppingCart;

	@Before
	public void init() {
		shoppingCart = new ShoppingCart();
	}
	
	@Test
	public void cartTotalTest() {
		shoppingCart.setCartTotal(100.0);
		
		assertEquals(Double.valueOf(100.0), Double.valueOf(shoppingCart.getCartTotal()));
	}
	
	@Test
	public void itensTest() {
		List<ShoppingCartItem> list = createList();
		
		shoppingCart.setItens(list);
		
		assertSame(list, shoppingCart.getItens());
	}
	
	@Test
	public void removeItemTest() {
		shoppingCart.setItens(createList());
		shoppingCart.setCartTotal(140.0);
		
		shoppingCart.removeItem(1L);
		
		assertThat(shoppingCart.getItens(), hasSize(2));
		assertEquals(Double.valueOf(130.0), Double.valueOf(shoppingCart.getCartTotal()));
	}
	
	@Test
	public void listCartTest() {
		List<ShoppingCartItem> list = new ArrayList<>();
		list.add(createItem(1L, "Prod 1", 10.0, 1));
		shoppingCart.setItens(list);
		shoppingCart.setCartTotal(10.0);
		String strList = "Product [id=1, name=Prod 1, value=10.0] X 1 = 10.0\r\nTotal = 10.0";
		
		String result = shoppingCart.listCart();
		
		assertEquals(strList, result);
	}
	
	@Test
	public void addItemTest() {
		ShoppingCartItem item = createItem(1L, "Prod 1", 10.0, 1);
		
		shoppingCart.addItem(item);
		
		assertEquals(Double.valueOf(10.0), Double.valueOf(shoppingCart.getCartTotal()));
		assertThat(shoppingCart.getItens(), hasSize(1));
		ShoppingCartItem shoppingCartItem = shoppingCart.getItens().get(0);
		assertSame(item, shoppingCartItem);
	}
	
	@Test
	public void updateCartTest() {
		List<ShoppingCartItem> list = new ArrayList<>();
		list.add(createItem(1L, "Prod 1", 10.0, 1));
		shoppingCart.setItens(list);
		shoppingCart.setCartTotal(10.0);
		
		ShoppingCartItem item = createItem(1L, "Prod 1", 10.0, 2);
		
		shoppingCart.updateItem(item);
		
		assertEquals(Double.valueOf(20.0), Double.valueOf(shoppingCart.getCartTotal()));
		assertThat(shoppingCart.getItens(), hasSize(1));
		ShoppingCartItem shoppingCartItem = shoppingCart.getItens().get(0);
		assertSame(item, shoppingCartItem);
		
	}
	
	private ShoppingCartItem createItem(long id, String name, double price, int quantity) {
		ShoppingCartItem sci = new ShoppingCartItem();
		Product p = new  Product();
		p.setId(id);
		p.setName(name);
		p.setValue(price);
		
		sci.setProduct(p);
		sci.setQuantity(quantity);
		
		return sci;
	}
	
	private List<ShoppingCartItem> createList() {
		List<ShoppingCartItem> list = new ArrayList<>();
		list.add(createItem(1L, "Prod 1", 10.0, 1));
		list.add(createItem(2L, "Prod 2", 20.0, 2));
		list.add(createItem(3L, "Prod 3", 30.0, 3));
		
		return list;
	}

}
