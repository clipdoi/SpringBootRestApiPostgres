package com.demo.services;

import com.demo.models.Product;

import java.util.List;

public interface ProductService {

	List<Product> getAllProduct();
	Product find(int id);
	Product save(Product product);
	boolean delete(int id);
    Product update(Product product);
	List<Product> searchByName(String keyword);
}
