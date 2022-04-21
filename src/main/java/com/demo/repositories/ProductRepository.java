package com.demo.repositories;

import java.util.List;

import com.demo.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {

		@Query("from Product where price >= :min and price <= :max and account = :account")
		public List<Product> searchByPrice(@Param("min") double min, @Param("max") double max);
		
		@Query("from Product where name like %:keyword%")
		public List<Product> searchByName(@Param("keyword") String keyword);

		@Query("from Product where categoryId = :categoryId")
		public List<Product> findAllByCategory(@Param("categoryId") int categoryId);

		@Query("from Product where status = true and name like %:keyword%")
		public List<Product> search(@Param("keyword") String keyword);

		@Query(value = "from product where price between :min and :max", nativeQuery = true)
		public List<Product> priceBetween(@Param("min") double min, @Param("max") double max);




}
