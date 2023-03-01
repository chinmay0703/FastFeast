


package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name="cart_items")
public class CartItem extends BaseEntity {
	
	
	//CartItem *---->1 Cart
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	//CartItem 1--->1 Product
	@OneToOne
	@JoinColumn(name="pizza_id")
	private Pizza cartProduct;
	public CartItem(){
		// TODO Auto-generated constructor stub
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Pizza getCartProduct() {
		return cartProduct;
	}
	
	public void setCartProduct(Pizza cartProduct) {
		this.cartProduct = cartProduct;
	}

	
}

