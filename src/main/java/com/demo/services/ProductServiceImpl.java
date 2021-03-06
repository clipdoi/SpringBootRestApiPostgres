package com.demo.services;

import com.demo.models.Product;
import com.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product find(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public boolean delete(int id) {
		try {
			productRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Product> searchByName(String keyword) {
		return productRepository.searchByName(keyword);
	}

	@Override
	public Product update(Product product) {
		Product p = productRepository.findById(product.getId()).get();
		p.setName(product.getName());
		p.setQuantity(product.getQuantity());
		p.setPrice(product.getPrice());
		p.setDescription(product.getDescription());
		p.setStatus(product.isStatus());
		p.setActivated(product.isActivated());
		p.setCreated(product.getCreated());
		return productRepository.save(p);
	}



}
