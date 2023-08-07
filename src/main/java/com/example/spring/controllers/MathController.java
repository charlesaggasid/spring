package com.example.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/*
Exercise 2
Create a MathController class.
This controller should listen for requests for several routes that correspond to basic arithmetic operations and
produce the result of the arithmetic.

url	response
/add/3/and/4	    7
/subtract/3/from/10	7
/multiply/4/and/5	20
/divide/6/by/3	    2

 */

@Controller
public class MathController {
	
	@GetMapping("/add/{num1}/{num2}")
	@ResponseBody
	public String add(@PathVariable int num1, @PathVariable int num2) {
		return num1 + " + " + num2 + " = " + (num1 + num2); //should bring up the sum in the browser
	}

//	@GetMapping("/add/{num1}/{num2}")
//	@ResponseBody
//	public Integer subtract(@PathVariable int num1, @PathVariable int num2) {
//		return num1 + num2; //should bring up the sum in the browser
//	}
//
//	@GetMapping("/add/{num1}/{num2}")
//	@ResponseBody
//	public Integer add(@PathVariable int num1, @PathVariable int num2) {
//		return num1 + num2; //should bring up the sum in the browser
//	}
//
//	@GetMapping("/add/{num1}/{num2}")
//	@ResponseBody
//	public Integer add(@PathVariable int num1, @PathVariable int num2) {
//		return num1 + num2; //should bring up the sum in the browser
//	}
	
}
