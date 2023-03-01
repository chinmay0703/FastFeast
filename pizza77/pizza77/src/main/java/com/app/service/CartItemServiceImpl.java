package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartItemDto;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Pizza;

import com.app.pojos.User;
import com.app.repository.CartItemsRepository;
import com.app.repository.PizzaRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemsRepository cartItemRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PizzaRepository PizzaRepo;
	@Autowired
	private PizzaService PizzaService;

//	@Override
//	public String addCartItem(CartItemDto newCartItem) {
//		// TODO Auto-generated method stub
//		System.out.println("inside cartimplementation !!");
//		User user = userRepo.findById(newCartItem.getUserId()).get();
//		// System.out.println(user);
//
//		List<Pizza> PizzaList = PizzaService.getAllPizzas(newCartItem.getCatId());
//		Pizza PizzaToAdd = new Pizza();
//
//		for (Pizza p : PizzaList) {
//			if (p.getId() == 4) {
//				PizzaToAdd = p;
//				// System.out.println(PizzaToAdd);
//			}
//		}
//		System.out.println("before cartItem");
//		CartItem cartItem = new CartItem();
//		cartItem.setCartProduct(PizzaToAdd);
////		System.out.println(cartItem.getCartProduct());
////		System.out.println("after cartItem");
//
//		if (user.getCart() == null) {
//			Cart cart = new Cart();
//			cart.addCartItem(cartItem);
//			user.addCart(cart);
//		} else {
//
//			user.getCart().addCartItem(cartItem);
//			user.addCart(user.getCart());
//		}
//
//		System.out.println("before setting cartCounts !!");
//		int totalItems = user.getCart().getTotalItems();
//		user.getCart().setTotalItems(totalItems + 1);
//		System.out.println("after setting cartCounts !!");
//
//		return "pizza added to cart successfully !!";
//	}

	@Override
	public String addCartItem(CartItemDto newCartItem) {
		// TODO Auto-generated method stub
		System.out.println("inside cartimplementation !!");
		User user = userRepo.findById(newCartItem.getUserId()).get();
		// System.out.println(user);

		List<Pizza> productList = PizzaService.getAllPizzas(newCartItem.getCatId());
		Pizza productToAdd = new Pizza();

		for (Pizza p : productList) {
			if (p.getId() == newCartItem.getPizzaid()) {
				productToAdd = p;
				// System.out.println(productToAdd);
			}
		}
		System.out.println("before cartItem");
		CartItem cartItem = new CartItem();
		cartItem.setCartProduct(productToAdd); // problem was here
		System.out.println(cartItem.getCartProduct());
		System.out.println("after cartItem");

		
		if (user.getCart() == null) {
			Cart cart = new Cart();
			cart.addCartItem(cartItem);
			user.addCart(cart);
			int totalItems = user.getCart().getTotalItems();
			user.getCart().setTotalItems(totalItems);
		} else {

			user.getCart().addCartItem(cartItem);
			user.addCart(user.getCart());
			int totalItems = user.getCart().getTotalItems();
			user.getCart().setTotalItems(totalItems + 1);
		}
	//	System.out.println("before setting cartCounts !!");
		
	//	System.out.println("after setting cartCounts !!");
		return "pizza booked successfully !!";
	}

}
