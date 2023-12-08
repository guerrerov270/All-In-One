package com.allinone.demo.service;

import com.allinone.demo.data.Product;
import com.allinone.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product productDetails) {
		Product product = productRepository.findById(id).orElse(null);
		if (product != null) {
			product.setName(productDetails.getName());
			product.setPrice(productDetails.getPrice());
			product.setKeyFeatures(productDetails.getKeyFeatures());
			return productRepository.save(product);
		}
		return null;
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	@Cacheable("product")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public List<Product> getAllProductsNoCache() {
		return productRepository.findAll();
	}
}
