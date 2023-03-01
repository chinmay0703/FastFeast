package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PizzaDto;
import com.app.dto.PizzaDtoToUpdate;
import com.app.pojos.Pizza;
import com.app.service.PizzaService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pizza")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping("/addPizza/{categoryId}")
	public Pizza addPizza(@PathVariable Long categoryId, @RequestBody PizzaDto newHospital) {
		Pizza newProduct = mapper.map(newHospital, Pizza.class);

		return pizzaService.addPizza(categoryId, newProduct);
	}

	@DeleteMapping("/deleteProduct/{pizzaId}")
	public String deleteHospital(@PathVariable Long pizzaId) {
		return pizzaService.deletePizza(pizzaId);
	}

	@GetMapping("/getAllProducts/{catId}")
	public List<Pizza> getAllProducts(@PathVariable Long catId) {
		return pizzaService.getAllPizzas(catId);
	}

	@PutMapping("/updatePizza")
	public Pizza updateProduct(@RequestBody PizzaDtoToUpdate detachedProduct) {

		return pizzaService.updatePizza(detachedProduct);
	}

}
