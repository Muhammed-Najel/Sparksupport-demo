package com.demo.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sales.models.Sale;
import com.demo.sales.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	SaleService saleService;
	
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Sale sale) {
        try {
        	saleService.addSale(sale);
            return new ResponseEntity<>(sale, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
