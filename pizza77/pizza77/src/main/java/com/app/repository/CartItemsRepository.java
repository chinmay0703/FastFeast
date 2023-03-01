package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.CartItem;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItem, Long>{

	
	

}
