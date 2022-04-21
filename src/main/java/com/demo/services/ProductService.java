package com.demo.services;

import com.demo.models.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {

	public Iterable<Product> getAllProduct();
	public Product find(int id);
	public Product save(Product product);
	public boolean delete(int id);
//	public Product update(Product product);
	public List<Product> searchByName(String keyword);
}
