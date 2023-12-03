package com.allinone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.allinone.demo.data.Product;
import com.allinone.demo.service.ProductService;
import com.allinone.demo.service.S3Service;

@Controller
public class SimpleController {

	@Autowired
	ProductService productService;
	
	@Autowired
	S3Service s3Service;
	
	@Value("${aws.s3.bannerURL}")
	private String bannerURL;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		
		model.addAttribute("bannerImageUrl", bannerURL);
		
		return "index";
	}

}
