package com.demo.sales.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.sales.models.Product;

public interface ProductService {

	Page<Product> getAllProducts(Pageable pageable);

	Product getProductById(Long id);

	void addProduct(Product product);

	void updateProduct(Long id, Product product);

	void deleteProduct(Long id);

	double getTotalRevenue();

	double getRevenueByProduct(Long productId);

}
