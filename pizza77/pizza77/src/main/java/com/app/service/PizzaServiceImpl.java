package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.PizzaDtoToUpdate;
import com.app.pojos.Category;
import com.app.pojos.Pizza;
import com.app.repository.PizzaRepository;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {

	
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private PizzaRepository PizzaRepo;
	
	
	
	

	@Override
	public List<Pizza> getAllPizzas(Long catId) {
		// TODO Auto-generated method stub
		
		//return PizzaRepo.findById(catId);
		List<Pizza> allPizzas=new ArrayList<>();
		allPizzas=PizzaRepo.findAll();
		List<Pizza> reqPizzas=new ArrayList<>();
		System.out.println(allPizzas);
		System.out.println(reqPizzas);
		for(Pizza p : allPizzas)
		{
			System.out.println(p.getPizzaCategory());
			if(p.getPizzaCategory().getId()==catId)
			{
				reqPizzas.add(p);
			}
		}
		System.out.println(reqPizzas);
		return reqPizzas;
	}

	@Override
	public Pizza addPizza(Long categoryId, Pizza addPizza) {
		Category cat = catService.findCategory(categoryId);
//		Category cat11=new Category();
//		cat11.addPizza(addHospital);
		Pizza newPizza= addPizza;
		newPizza.setPizzaCategory(cat);
		return PizzaRepo.save(newPizza);
		
	}

	@Override
	public String deletePizza(Long PizzaId) {
		// TODO Auto-generated method stub
		String msg = "Deletion of Pizza details failed Invalid Id!!!!!!!!!!!";
		if(PizzaRepo.existsById(PizzaId))
		{
			PizzaRepo.deleteById(PizzaId);
			msg="Pizza deleted successfully !!";
		}
		return msg;
	}

	@Override
	public Pizza updatePizza(PizzaDtoToUpdate detachedPizza) {
		// TODO Auto-generated method stub
		String msg="invalid PizzaId";
		Pizza persistentPizza=PizzaRepo.findById(detachedPizza.getId())
				.orElseThrow(() -> new ResourceNotFoundException("invalid Pizza id !!!!!"));
		if(persistentPizza!=null)
		{
			persistentPizza.setPizzaName(detachedPizza.getPizzaName());
			persistentPizza.setDescription(detachedPizza.getDescription());
			persistentPizza.setImage(detachedPizza.getImage());
			persistentPizza.setPrice(detachedPizza.getPrice());
		//	persistentPizza.setImage(detachedPizza.getImage());
		//	persistentPizza.setPrice(detachedPizza.getPrice());
			
			return persistentPizza;
		}
		return null;
		
	}

	
	

	
}
