package com.bootcamp.kitchenapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bootcamp.kitchenapp.model.Ingredient;
import com.bootcamp.kitchenapp.service.KitchenService;

@Controller
public class KitchenController {

	private KitchenService kitchenService;

	@Autowired
	public KitchenController(KitchenService kitchenService) {
		this.kitchenService = kitchenService;
	}

	@GetMapping(value = "/inventory")
	public String getInventory(Model model, Ingredient inventory) {
		model.addAttribute("inventoryTitle", "This is what you have at home");
		model.addAttribute("inventory", kitchenService.getInventory());
		return "inventory";

	}

	@GetMapping(value = "/addingredient")
	public String addIngredient(@ModelAttribute Ingredient ingredient) {
		if (ingredient.getName() != "" && ingredient.getQuantity() != 0 && ingredient.getUnit() != "") {
			kitchenService.addIngredient(ingredient);
		}
		return "addIngredient";
	}

}
