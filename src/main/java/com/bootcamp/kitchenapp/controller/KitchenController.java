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
		if (inventory.getName() != "" && inventory.getQuantity() != 0 && inventory.getUnit() != "") {
			model.addAttribute("inventory", kitchenService.getInventory());
			return "inventory";
		}else {
			return null;
		}
	}

	@GetMapping(value = "/addingredient")
	public String addIngredient(@ModelAttribute Ingredient ingredient) {
		kitchenService.addIngredient(ingredient);
		return "addIngredient";
	}

	/*
	 * @GetMapping(value ="/name") public Ingredient getIngredientByName(Model
	 * model, @RequestParam(value = "name") String name) {
	 * model.addAttribute("inventory", kitchenService.getIngredientByName(name));
	 * return "inventory"; }
	 */

}
