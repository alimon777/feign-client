package com.ust.feign.ifaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ust.feign.model.Product;
import java.util.List;

@FeignClient(value="productFeignClient", url="http://localhost:8090/product/api1.0")
public interface ProductFeignInterface {
	@GetMapping("/all")
	public List<Product> getAllProduct();
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable Long id);
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product);
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product);
	
	@DeleteMapping(value="/delete/{id}")
	public Product deleteProduct(@PathVariable Long id);
}
