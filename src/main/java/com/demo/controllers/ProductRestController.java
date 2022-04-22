package com.demo.controllers;

import com.demo.models.Product;
import com.demo.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{keyword}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String keyword) {
        return new ResponseEntity<>(productService.searchByName(keyword), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        log.info("product: {}", product);
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        log.info("product: {}", product);
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        return new ResponseEntity<>(String.valueOf(productService.delete(Integer.parseInt(id))), HttpStatus.OK);
    }


}
