package br.com.ecommerce.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 4673803170409071849L;

	private List<ShoppingCartItem> itens;
	
	private double cartTotal;
	
	public ShoppingCart() {
		itens = new ArrayList<ShoppingCartItem>();
	}
	
	public void addItem(ShoppingCartItem item) {
		if(!itens.contains(item)) {
			itens.add(item);
			cartTotal += item.calculateTotalPrice();
		}
	}

	public void removeItem(long productId) {
		Optional<ShoppingCartItem> fci = itens.stream().filter(ci -> ci.getProduct().getId() == productId).findFirst();
		
		if(fci.isPresent()) {
			ShoppingCartItem item = fci.get();
			itens.remove(item);
			cartTotal -= item.calculateTotalPrice();
		}
	}

	public void updateItem(ShoppingCartItem item) {
		if(itens.contains(item)) {
			int indexOf = itens.indexOf(item);
			ShoppingCartItem sci = itens.get(indexOf);
			cartTotal -= sci.calculateTotalPrice();
			itens.set(indexOf, item);
			cartTotal += item.calculateTotalPrice();
		}
	}
	
	public String listCart() {
		StringBuilder sb = new StringBuilder();
		
		if(!itens.isEmpty()) {
			itens.forEach(item -> sb.append(item.getProduct()).append(" X ").append(item.getQuantity()).append(" = ").append(item.calculateTotalPrice()).append("\r\n"));
			sb.append("Total = ").append(cartTotal);
		}
		
		return sb.toString();
	}

	public List<ShoppingCartItem> getItens() {
		return itens;
	}

	public void setItens(List<ShoppingCartItem> itens) {
		this.itens = itens;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	
}
