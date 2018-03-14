package br.com.ecommerce.cart.model;

import br.com.ecommerce.product.model.Product;

public class ShoppingCartItem {
	
	public ShoppingCartItem() {}
	
	public ShoppingCartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	private Product product;
	private int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public double calculateTotalPrice() {
		return quantity * product.getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 2;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartItem other = (ShoppingCartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	
	
}
