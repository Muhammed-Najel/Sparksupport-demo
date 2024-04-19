package com.demo.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.sales.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
