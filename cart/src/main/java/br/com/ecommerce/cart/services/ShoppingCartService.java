package br.com.ecommerce.cart.services;

public interface ShoppingCartService {
	
	public String getShoppingCart();
	public void addShoppingCartItem(long productId, int quantity);
	public void updateShoppingCartItem(long productId, int quantity);
	public void deleteShoppingCartItem(long productId);

}
