package com.app.pojos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * Product Entity : id, name,price,desc,inStock +
private Category productCategory;

 */
@Entity
@Table(name = "pizza")
public class Pizza extends BaseEntity {
	@Column( length = 30, unique = true)
	private String pizzaName;
	@Column(length = 20)
	private String description;
	@Column(length = 20)
	private String image;
	private int price;
	
	//private String description;
	//@Column(name = "in_stock")
	//private int inStock;
//	// many to one Product *-----> 1Category
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category pizzaCategory;
	// Product 1----->1 CartItem
	//private String productName;

	public Pizza() {
		// TODO Auto-generated constructor stub
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

	public Category getPizzaCategory() {
		return pizzaCategory;
	}

	public void setPizzaCategory(Category pizzaCategory) {
		this.pizzaCategory = pizzaCategory;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaName=" + pizzaName + ", description=" + description + ", image=" + image + ", price="
				+ price +  "]";
	}

	public Pizza(String pizzaName, String description, String image, int price, Category pizzaCategory) {
		super();
		this.pizzaName = pizzaName;
		this.description = description;
		this.image = image;
		this.price = price;
		this.pizzaCategory = pizzaCategory;
	}



	
	
}
