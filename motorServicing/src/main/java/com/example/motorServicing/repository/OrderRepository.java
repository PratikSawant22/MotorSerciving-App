package com.example.motorServicing.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.motorServicing.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {
	 List<Order> findByUser(String user );
	 
	 @Transactional
	 @Modifying
	 @Query("update Order o set o.status = ?1 where o.id = ?2") 
	 void updateOrderStatus(String status,long id);
	 //int

}
