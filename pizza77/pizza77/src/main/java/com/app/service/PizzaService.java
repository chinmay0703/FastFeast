package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.LoginRequestDto;
import com.app.dto.PizzaDtoToUpdate;
import com.app.pojos.Category;
import com.app.pojos.Pizza;
import com.app.pojos.User;


public interface PizzaService {

	
	List<Pizza> getAllPizzas(Long catId);

	Pizza addPizza(Long categoryId, Pizza addPizza);

	String deletePizza(Long PizzaId);

	 Pizza updatePizza(PizzaDtoToUpdate detachedPizza);
	
}
