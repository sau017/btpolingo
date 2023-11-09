package com.example.db.dbapp;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.db.dbapp.entities.AddressODataAgent;
import com.example.db.dbapp.entities.VendorODataAgent;

@SpringBootApplication(scanBasePackages = "com.example.db.dbapp")
@EnableJpaRepositories(basePackages = "com.example.db.dbapp")
@EntityScan(basePackages = "com.example.db.dbapp") 
@ServletComponentScan(basePackages = "com.example.db.dbapp")
@EnableAsync

public class DbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbappApplication.class, args);
	}
	@Bean(name="com.example.db.dbapp.processor.MyODataServiceFactory")
	public ODataServiceFactory getServiceFactory(){
		return new com.example.db.dbapp.processor.MyODataServiceFactory("com.example.db.dbapp");
	}
	
	@Bean(name="com.example.db.dbapp.entities.VendorODataAgent")
	public VendorODataAgent vendorODataAgent(){
		return new VendorODataAgent();
	}
	
	@Bean(name="com.example.db.dbapp.entities.AddressODataAgent")
	public AddressODataAgent addressODataAgent(){
		return new AddressODataAgent();
	}


}
