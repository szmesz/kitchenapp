package com.bootcamp.kitchenapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.kitchenapp.dao.KitchenDao;
import com.bootcamp.kitchenapp.model.Ingredient;

@Service
public class KitchenService {

	private KitchenDao kitchenDao;

	@Autowired
	public KitchenService(KitchenDao kitchenDao) {
		this.kitchenDao = kitchenDao;
	}

	public ArrayList<Ingredient> getInventory() {
		return kitchenDao.getInventory();
	}

	public void addIngredient(Ingredient ingredient) {
		Ingredient ingredientInDB = kitchenDao.getIngredientByName(ingredient.getName());
		if (ingredientInDB == null || ingredientInDB.getName().equals("")) {
			kitchenDao.addIngredient(ingredient);
		} else {
			float oldQuantity = ingredientInDB.getQuantity();
			float newQuantity = ingredient.getQuantity();
			long id = ingredientInDB.getId();
			Ingredient updatedIngredient = new Ingredient(ingredientInDB.getName(), oldQuantity + newQuantity,
					ingredientInDB.getUnit());
			updatedIngredient.setId(id);
			kitchenDao.addIngredient(updatedIngredient);
		}

	}
}
