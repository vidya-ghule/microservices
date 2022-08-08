package com.example.Microservices.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
	public class Product {
	private String procudtId;
		private String productName;
		private float productPrice;
		private Date productExpiryDate;
		
		
			}


