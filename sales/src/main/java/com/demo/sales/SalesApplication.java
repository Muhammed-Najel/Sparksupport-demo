package com.demo.sales;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.sales.models.Product;
import com.demo.sales.models.Sale;
import com.demo.sales.service.ProductService;
import com.demo.sales.service.SaleService;

@SpringBootApplication
public class SalesApplication implements CommandLineRunner {

	@Autowired
	ProductService productService;

	@Autowired
	SaleService saleService;

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product laptop = new Product("Laptop", "High-performance laptop", 1000.00, 10, null);
		productService.addProduct(laptop);
		Date today = new Date();
		Sale laptopSale = new Sale(5, today, laptop);
		saleService.addSale(laptopSale);

		Product headphones = new Product("Headphones", "Wireless Noise-Cancelling", 200.00, 25, null);
		productService.addProduct(headphones);
		Sale headphoneSale = new Sale(3, today, headphones);
		saleService.addSale(headphoneSale);

		Product tshirt = new Product("T-Shirt", "Graphic Design", 20.00, 50, null);
		productService.addProduct(tshirt);
		Sale tshirtSale = new Sale(8, today, tshirt);
		saleService.addSale(tshirtSale);

		Product coffeeMaker = new Product("Coffee Maker", "Programmable Coffee Brewer", 80.00, 15, null);
		productService.addProduct(coffeeMaker);
		Sale coffeeMakerSale = new Sale(2, today, coffeeMaker);
		saleService.addSale(coffeeMakerSale);

		Product book = new Product("Book", "Bestselling Novel", 15.00, 30, null);
		productService.addProduct(book);
		Sale bookSale = new Sale(4, today, book);
		saleService.addSale(bookSale);

		System.out.println("Products and sales created and saved.");

	}

}
