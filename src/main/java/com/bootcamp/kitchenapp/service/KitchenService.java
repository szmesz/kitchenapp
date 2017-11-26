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

	/*public String getIngredientByName(String name) {
		return kitchenDao.getIngredientByName(name);

	}*/

	public void addIngredient(Ingredient ingredient) {
		kitchenDao.addIngredient(ingredient);

	}
}
