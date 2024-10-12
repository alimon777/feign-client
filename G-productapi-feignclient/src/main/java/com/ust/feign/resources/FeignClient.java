package com.ust.feign.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.feign.ifaces.ProductFeignInterface;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ust.feign.model.Product;
import java.util.List;

@RestController
@RequestMapping("/client")
public class FeignClient {
	@Autowired
	private ProductFeignInterface feignclient;
	
	@GetMapping("/products")
	public List<Product> getAll() {
		return feignclient.getAllProduct();
	}
	
	@GetMapping("/product/{id}")
	public Product getById(@PathVariable Long id) {
		return feignclient.getProductById(id);
	}
	
	@PostMapping("/addProduct")
	public Product add(@RequestBody Product product) {
		return feignclient.addProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public Product update(@RequestBody Product product) {
		return feignclient.updateProduct(product);
	}
	
	@DeleteMapping(value="/deleteProduct/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		return feignclient.deleteProduct(id);
	}
	
}
