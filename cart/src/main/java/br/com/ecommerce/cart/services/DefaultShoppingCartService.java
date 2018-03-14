package br.com.ecommerce.cart.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ecommerce.cart.model.ShoppingCart;
import br.com.ecommerce.cart.model.ShoppingCartItem;
import br.com.ecommerce.product.model.Product;
import br.com.ecommerce.product.repositories.ProductRepository;

public class DefaultShoppingCartService implements ShoppingCartService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ShoppingCart shoppingCart;

	@Override
	public String getShoppingCart() {
		return shoppingCart.toString();
	}

	@Override
	public void addShoppingCartItem(long productId, int quantity) {
		ShoppingCartItem sci = createCartItem(productId, quantity);
		shoppingCart.addItem(sci);
	}



	@Override
	public void updateShoppingCartItem(long productId, int quantity) {
		ShoppingCartItem sci = createCartItem(productId, quantity);
		shoppingCart.updateItem(sci);
	}

	@Override
	public void deleteShoppingCartItem(long productId) {
		shoppingCart.removeItem(productId); 
	}

	private ShoppingCartItem createCartItem(long productId, int quantity) {
		Product product = productRepository.findById(productId);
		ShoppingCartItem sci = new ShoppingCartItem(product, quantity);
		return sci;
	}
	
}
