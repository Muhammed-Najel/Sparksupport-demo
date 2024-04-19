package com.demo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sales.models.Sale;
import com.demo.sales.repository.SaleRepository;
import com.demo.sales.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleRepository saleRepository;

	@Override
	public void addSale(Sale sale) {
		try {
			saleRepository.save(sale);
		} catch (Exception e) {
			throw new RuntimeException("Failed to add product. Please try again later.");
		}
	}
}
