package com.demo.sales.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.sales.controller.ProductController;
import com.demo.sales.models.Product;
import com.demo.sales.models.Sale;
import com.demo.sales.repository.ProductRepository;
import com.demo.sales.service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		try {
			return productRepository.findAll(pageable);
		} catch (Exception e) {
			logger.error("Error fetching products: {}", e.getMessage());
			throw new RuntimeException("Failed to retrieve products. Please try again later.");
		}
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product with ID " + id + " not found"));
	}

	@Override
	public void addProduct(Product product) {
		try {
			productRepository.save(product);
		} catch (Exception e) {
			logger.error("Error adding product: {}", e.getMessage());
			throw new RuntimeException("Failed to add product. Please try again later.");
		}
	}

	@Override
	public void updateProduct(Long id, Product product) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product with ID " + id + " not found"));

		// Update the existing product
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());

		productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product with ID " + id + " not found"));

		productRepository.deleteById(id);
	}

	@Override
	public double getTotalRevenue() {
		double totalRevenue = 0.0;
		for (Product product : productRepository.findAll()) {
			for (Sale sale : product.getSales()) {
				totalRevenue += sale.getQuantity() * product.getPrice();
			}
		}
		return totalRevenue;
	}

	@Override
	public double getRevenueByProduct(Long productId) {
		double productRevenue = 0.0;
		for (Product product : productRepository.findAll()) {
			if (product.getId().equals(productId)) {
				for (Sale sale : product.getSales()) {
					productRevenue += sale.getQuantity() * product.getPrice();
				}
				return productRevenue;
			}
		}
		return 0.0; // Product not found, return 0 revenue
	}

}