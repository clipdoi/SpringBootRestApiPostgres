package com.demo.services;

import com.demo.models.Product;

public interface ProductService {

	public Iterable<Product> getAllProduct();
	public Product find(int id);
	public Product save(Product product);
	public boolean delete(int id);
	public Product update(Product product);
}
