package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceException;
import com.example.demo.model.Medicines;
import com.example.demo.repository.MedicineRepository;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")

public class MedicineController {
	@Autowired
	private MedicineRepository medicineRepository;
	
	// get all medicines
	@GetMapping("/medicines")
	public List<Medicines> getAllMedicines(){
		return medicineRepository.findAll();
	}	
	@GetMapping("/search/{keyword}")
	public List<Medicines> listAll(@PathVariable("keyword") String keyword) {
		if (keyword != null) {
			return medicineRepository.search(keyword);
		}
		return medicineRepository.findAll();
		}
		@GetMapping("/sort")
		public List<Medicines> sortAll(){
			return medicineRepository.findByOrderByNameAsc();
		}
		@GetMapping("/sortprice")
		public List<Medicines> sortPrice(){
			return medicineRepository.findByOrderByPriceAsc();
		}
	// create medicine rest api
	@PostMapping("/medicines")
	public Medicines createMedicines(@RequestBody Medicines medicine) {
		
		return medicineRepository.save(medicine);
		
	}
	
	
	// get employee by id rest api
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicines> getMedicinesById(@PathVariable Long id) {
		Medicines medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new ResourceException("Employee not exist with id :" + id));
		return ResponseEntity.ok(medicine);
	}
	
	// update employee rest api
	
	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicines> updateMedicines(@PathVariable Long id, @RequestBody Medicines medicineDetails){
		Medicines medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new ResourceException("Medicine not exist with id :" + id));
		
		
		medicine.setName(medicineDetails.getName());
		medicine.setImage(medicineDetails.getImage());
		medicine.setBrand(medicineDetails.getBrand());
		
		medicine.setPrice(medicineDetails.getPrice());
		medicine.setQuantity(medicineDetails.getQuantity());
		medicine.setDescription(medicineDetails.getDescription());
		medicine.setStatus(medicineDetails.getStatus());
		
		
		Medicines updatedMedicines = medicineRepository.save(medicine);
		return ResponseEntity.ok(updatedMedicines);
	}
	
	// delete employee rest api
	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMedicines(@PathVariable Long id){
		Medicines medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new ResourceException("Medicines not exist with id :" + id));
		
		medicineRepository.delete(medicine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
