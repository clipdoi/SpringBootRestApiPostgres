package com.demo.repositories;

import com.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

		@Query("from Product where price >= :min and price <= :max and account = :account")
		List<Product> searchByPrice(@Param("min") double min, @Param("max") double max);
		
		@Query("from Product where name like %:keyword%")
		List<Product> searchByName(@Param("keyword") String keyword);

		@Query("from Product where categoryId = :categoryId")
		List<Product> findAllByCategory(@Param("categoryId") int categoryId);

		@Query("from Product where status = true and name like %:keyword%")
		List<Product> search(@Param("keyword") String keyword);

		@Query(value = "from product where price between :min and :max", nativeQuery = true)
		List<Product> priceBetween(@Param("min") double min, @Param("max") double max);




}
