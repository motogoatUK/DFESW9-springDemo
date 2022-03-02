package com.qa.chocolate.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.chocolate.domain.Chocolates;

@RestController
public class ChocolateController {
	private List<Chocolates> choco = new ArrayList<>();

	// Create -POST
	@PostMapping("/createChoco")
	public void createChoco(@RequestBody Chocolates c) {
		this.choco.add(c);
	}

	// Read - GET
	@GetMapping("/getChoco")
	public List<Chocolates> getChoco() {
		return this.choco;
	}
	//get by Id
	@GetMapping("/getOne/{id}")
	public Chocolates getChocoById(@PathVariable int id) {
		return this.choco.get(id);
	}
	// Update - PATCH/PUT
	@PutMapping("/updateChoco/{id}")
	public Chocolates updateChocolate(@PathVariable int id, @RequestBody Chocolates ch) {
		//
		//this.choco.remove(id);
		//this.choco.add(id,ch);
		//
		//set combines remove and add
		this.choco.set(id, ch);
		//
		return this.choco.get(id);
		
	}
	
	// Delete - DELETE
	@DeleteMapping("/removeChoco/{id}")
	public Chocolates removeChoco(@PathVariable int id) {
		return this.choco.remove(id);
	}
	
}
