package br.com.ecommerce.cart.services;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ecommerce.cart.model.ShoppingCart;
import br.com.ecommerce.product.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DefaultShoppingCartService.class})
@EnableAutoConfiguration
public class ShoppingCartServiceTest {
	
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@MockBean
	private ShoppingCart shoppingCart; 
	
	@Test
	public void getShoppingCart_called_success() {
		String list = "listCart";
		when(shoppingCart.listCart()).thenReturn(list);
		
		String result = shoppingCartService.getShoppingCart();
		
		verify(shoppingCart).listCart();
		assertSame(list, result);
	}

	
	@Test
	public void deleteShoppingCartItem_called_success() {
		long id = 10L;
		
		shoppingCartService.deleteShoppingCartItem(id);
		
		verify(shoppingCart).removeItem(id);
	}
}
