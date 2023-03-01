package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CategoryDtoToUpdate;
import com.app.pojos.Category;
import com.app.pojos.Pizza;
import com.app.repository.CartRepository;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

  @Autowired
  private CartRepository cartRepo;
  
  
  
	
}
