package com.AbajoDelReloj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AbajoDelReloj.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
