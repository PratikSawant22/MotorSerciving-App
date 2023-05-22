package com.example.motorServicing.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.motorServicing.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Modifying
	@Transactional
	@Query("delete from Product b where b.id=:id")
	void deleteProduct(@Param("id") Long id);
}