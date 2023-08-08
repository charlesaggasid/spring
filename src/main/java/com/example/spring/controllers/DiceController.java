package com.example.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceController {
	
	@GetMapping("/roll-dice")
	public String rollDicePage() {
		return "roll-dice";
	}
	
	@GetMapping("/roll-dice/{guess}")
	public String rollDice(@PathVariable int guess, Model model) {
		int rolls = 5; // Number of dice rolls
		int matchingRolls = 0;
		List<Integer> rollResults = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < rolls; i++) {
			int roll = random.nextInt(6) + 1;
			rollResults.add(roll);
			if (roll == guess) {
				matchingRolls++;
			}
		}
		
		model.addAttribute("guess", guess);
		model.addAttribute("rollResults", rollResults);
		model.addAttribute("matchingRolls", matchingRolls);
		
		return "roll-dice-result";
	}
	
}
