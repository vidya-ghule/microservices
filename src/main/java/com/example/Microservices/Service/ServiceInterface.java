package com.example.Microservices.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Microservices.Entity.User;
import com.example.Microservices.Model.User_Product;

@Service
public interface ServiceInterface {
	
	public String saveUser(User user);
	public User getuserbyname(String userName);
	public User_Product GetUserwithproductUsername(String username);
    public List<User_Product> getuserproductlist();
}
