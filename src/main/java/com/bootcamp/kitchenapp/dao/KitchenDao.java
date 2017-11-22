package com.bootcamp.kitchenapp.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.kitchenapp.model.Ingredient;

@Repository
public class KitchenDao {

	private KitchenRepository kitchenRepository;

	@Autowired
	public KitchenDao(KitchenRepository kitchenRepository) {
		this.kitchenRepository = kitchenRepository;
	}

	public ArrayList<Ingredient> getInventory() {
		ArrayList<Ingredient> ingredients = (ArrayList<Ingredient>) kitchenRepository.findAll();
		ingredients.forEach(e -> System.out.println(e));
		return ingredients;
	}

	public String getIngredientByName(String name) {
		return name;

	}

	public void addIngredient(Ingredient ingredient) {
		kitchenRepository.save(ingredient);
	}

}
