package com.demo.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.sales.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
