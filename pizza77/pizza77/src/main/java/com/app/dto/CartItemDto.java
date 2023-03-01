package com.app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class CartItemDto {
	
	
	private Long catId;
	private Long userId;
   private Long Pizzaid;
	public CartItemDto() {
	super();
}
	
	public CartItemDto(Long catId, Long userId, Long pizzaid) {
		super();
		this.catId = catId;
		this.userId = userId;
		Pizzaid = pizzaid;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPizzaid() {
		return Pizzaid;
	}

	public void setPizzaid(Long pizzaid) {
		Pizzaid = pizzaid;
	}

	@Override
	public String toString() {
		return "CartItemDto [catId=" + catId + ", userId=" + userId + ", Pizzaid=" + Pizzaid + "]";
	}

	

	

	

	
	
}
