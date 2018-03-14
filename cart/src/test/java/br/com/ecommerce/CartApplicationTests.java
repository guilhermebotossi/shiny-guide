package br.com.ecommerce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ecommerce.cart.model.ShoppingCart;

@ContextConfiguration(classes = {ShoppingCart.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartApplicationTests {

	@Test
	public void contextLoads() { 
	}

}
