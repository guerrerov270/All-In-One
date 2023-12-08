package com.allinone.demo.controller;

import com.allinone.demo.data.Product;
import com.allinone.demo.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model) {
    	Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "product-detail";
    }
	
	@GetMapping("/celulares")
    public String celulares(Model model) {
		List<Product> products= productService.getAllProducts();
		model.addAttribute("products", products);
		return "products";
    }

}
