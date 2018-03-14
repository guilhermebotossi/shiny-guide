package br.com.ecommerce.cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.cart.services.ShoppingCartService;

@RestController
@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping(path = "/viewCart",method = RequestMethod.GET)
	public String getShoppingCart() {
		return shoppingCartService.getShoppingCart();
	}
	
	@RequestMapping(path = "/addItem",method = RequestMethod.POST)
	public void addShoppingCartItem(long productId, int quantity) {
		shoppingCartService.addShoppingCartItem(productId, quantity);
	}
	
	
	@RequestMapping(path = "/updateItem",method = RequestMethod.PUT)
	public void updateShoppingCartItem(long productId, int quantity) {
		shoppingCartService.updateShoppingCartItem(productId, quantity);
	}
	
	@RequestMapping(path = "/removeItem",method = RequestMethod.DELETE)
	public void deleteShoppingCartItem(long productId) {
		shoppingCartService.deleteShoppingCartItem(productId);
	}

	
	

}
