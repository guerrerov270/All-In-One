package com.allinone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.allinone.demo.data.Product;
import com.allinone.demo.service.ProductService;

@Controller
public class SimpleController {

	@Autowired
	ProductService productService;

	@Value("${aws.s3.bannerURL}")
	private String bannerURL;
	
	@Value("${aws.s3.celulares.url}")
	private String celularesURL;
	
	@Value("${aws.s3.computadores.url}")
	private String computadoresURL;
	
	@Value("${aws.s3.televisores.url}")
	private String televisoresURL;
	
	@Value("${aws.s3.videojuegos.url}")
	private String videojuegosURL;
	
	@Value("${aws.s3.accesorios.url}")
	private String accesoriosURL;
	
	@Value("${aws.s3.audio.url}")
	private String audioURL;
	
	@Value("${aws.s3.navidad.url}")
	private String navidadURL;
	
	@Value("${aws.s3.llantas.url}")
	private String llantasURL;
	
	@Value("${aws.s3.hogar.url}")
	private String hogarURL;
	
	@Value("${aws.s3.pines.url}")
	private String pinesURL;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		
		model.addAttribute("bannerImageUrl", bannerURL);
		
		model.addAttribute("celularesURL", celularesURL);
		model.addAttribute("computadoresURL", computadoresURL);
		
		model.addAttribute("televisoresURL", televisoresURL);
		model.addAttribute("videojuegosURL", videojuegosURL);
		
		model.addAttribute("accesoriosURL", accesoriosURL);
		model.addAttribute("audioURL", audioURL);
		
		model.addAttribute("navidadURL", navidadURL);
		model.addAttribute("llantasURL", llantasURL);
		
		model.addAttribute("hogarURL", hogarURL);
		model.addAttribute("pinesURL", pinesURL);
		
		
		return "index";
	}

}
