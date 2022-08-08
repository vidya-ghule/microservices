package com.example.Microservices.Model;

import java.util.List;

import com.example.Microservices.Entity.Product;
import com.example.Microservices.Entity.User;

import lombok.Data;
@Data
public class User_Product {
	
	
	private User user;
	private Product product;

	
	public User_Product(User user2, Product product2) {
		// TODO Auto-generated constructor stub
	}


	public User_Product() {
		// TODO Auto-generated constructor stub
	}
}
