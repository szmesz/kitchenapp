package com.bootcamp.kitchenapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.kitchenapp.model.Ingredient;

public interface KitchenRepository extends CrudRepository<Ingredient, Long> {
	
	Ingredient findByName(String name);

}
