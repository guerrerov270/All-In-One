package com.allinone.demo;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import com.allinone.demo.data.Feature;
import com.allinone.demo.data.Product;
import com.allinone.demo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

	@Autowired
	private ProductRepository productRepository;
	
	@Value("${aws.s3.celular1.url}")
	private String celular1URL;
	
	@Value("${aws.s3.laptop1.url}")
	private String laptop1URL;


	@PostConstruct
	public void initData() {
	    if (productRepository.findByName("Smartphone XYZ") == null) {
	        List<Feature> featuresForProduct1 = new ArrayList<>();
	        featuresForProduct1.add(new Feature("Pantalla táctil"));
	        featuresForProduct1.add(new Feature("Conectividad Bluetooth"));

	        Product product1 = new Product("Smartphone XYZ", 799.99, featuresForProduct1, celular1URL);
	        productRepository.save(product1);
	    }

	    if (productRepository.findByName("Laptop ABC") == null) {
	        List<Feature> featuresForProduct2 = new ArrayList<>();
	        featuresForProduct2.add(new Feature("Conectividad Bluetooth"));
	        featuresForProduct2.add(new Feature("Cámara de alta resolución"));

	        Product product2 = new Product("Laptop ABC", 1200.00, featuresForProduct2, laptop1URL);
	        productRepository.save(product2);
	    }
	}
}
