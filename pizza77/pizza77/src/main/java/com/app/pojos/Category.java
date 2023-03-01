package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * 2. Category : id,  categoryName ,description +
private List<Pizza> Pizzas=new ArrayList<>();//as pePizzaCategoryr Gavin King's suggestion : DO NOT keep collection based null
 */
@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	@Column(length = 30,unique = true)
	private String categoryName;
	@Column(length = 300)
	private String description;
	// one to many : bi dir Category 1--->* Pizza
	//Category -- one , parent , inverse(since no FK mapping)
	@JsonBackReference
	@OneToMany(mappedBy = "pizzaCategory",
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pizza> pizzas = new ArrayList<>(); // init to empty list

	public Category(){
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	// Founder's suggestion : NEVER add asso properties toString --o.w may cause
	// recursion!

	@Override
	public String toString() {
		return "Category ID " + getId() + " [categoryName=" + categoryName + ", description=" + description + "]";
	}
	//add a method(convenience/helper) to establish a bi dir asso. between entities
	public void addPizza(Pizza p)
	{
		//parent --> child
		pizzas.add(p);
		//child --> parent
		p.setPizzaCategory(this);
	}
	//add a method(convenience/helper) to remove a bi dir asso. between entities
		public void removePizza(Pizza p)
		{
			//parent ----X---> child
			pizzas.remove(p);
			//child ----X----> parent
			p.setPizzaCategory(null);			
		}

}
