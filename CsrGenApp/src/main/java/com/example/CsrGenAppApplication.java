package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CsrGenAppApplication extends SpringBootServletInitializer {
	
	/*
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CsrGenAppApplication.class);
    }
	*/
	public static void main(String[] args) {
		SpringApplication.run(CsrGenAppApplication.class, args);
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/field")
	public String field() {
		return "field";
	}

}
