package com.app.dto;

public class PizzaDto {
	private String pizzaName;
	
	
	private String description;
	private String image;

	private int price;

	public PizzaDto() {
		super();
	}

	public PizzaDto(String pizzaName, String description, String image, int price) {
		super();
		this.pizzaName = pizzaName;
		this.description = description;
		this.image = image;
		this.price = price;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	
	//Product 1----->1 CartItem
}
