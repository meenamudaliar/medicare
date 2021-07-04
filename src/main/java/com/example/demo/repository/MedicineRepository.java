package com.example.demo.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.stereotype.Repository;

import com.example.demo.model.Medicines;

public interface MedicineRepository extends JpaRepository<Medicines,Long>{
	@Query("SELECT m FROM Medicines m WHERE CONCAT(m.name, ' ', m.brand, ' ',m.description,' ', m.price) LIKE %?1%")
	public List<Medicines> search(String keyword);

	public List<Medicines> findByOrderByNameAsc();

	public List<Medicines> findByOrderByPriceAsc();
	
}
