package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import com.demo.models.Product;
import com.demo.services.ProductService;


@RestController
@RequestMapping("api/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value="getAllProduct", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Product>> getAllProduct(){
		try {

			return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

//	@RequestMapping(value="create", method= RequestMethod.POST,
//			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
//			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Product2> create(@RequestBody Product2 product){
//		try {
//			System.out.println("id: " + product.getId());
//			System.out.println("name: "+product.getName());
//			return new ResponseEntity<Product2>(productService.save(product), HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<Product2>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@RequestMapping(value="update", method= RequestMethod.PUT,
//			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
//			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Product2> update(@RequestBody Product2 product){
//		try {
//			System.out.println("id: " + product.getId());
//			System.out.println("name: "+product.getName());
//			return new ResponseEntity<Product2>(productService.update(product), HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<Product2>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@RequestMapping(value="delete/{id}", method= RequestMethod.DELETE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> delete(@PathVariable("id") String id){
//		try {
//			return new ResponseEntity<String>(String.valueOf(productService.delete(Integer.parseInt(id))), HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}


}
