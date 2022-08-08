package com.example.Microservices.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.Microservices.Dao.DaoInterface;
import com.example.Microservices.Entity.Product;
import com.example.Microservices.Entity.User;
import com.example.Microservices.Model.User_Product;
@Service
public class serviceImpl implements ServiceInterface {

	@Autowired
	DaoInterface daoInterface;
	@Autowired
	RestTemplate resttemplate;

	@Override
	public String saveUser(User user) {
		User usersave=daoInterface.save(user);
		System.out.println(usersave);
	
		return "user saved sucessfullly!!!!";
		
	}

	@Override
	public User getuserbyname(String userName) {
		User user=daoInterface.getReferenceById(userName);
		if(user!=null) {
			return user;
		}
		return null;
	}

	@Override
	public User_Product GetUserwithproductUsername(String username) {
		User_Product user_Product=new User_Product();
		User user=getuserbyname(username);
		System.out.println("user>>"+user);
		Product product=resttemplate.getForObject("http://localhost:8080/GetProductById/"+user.getProcudtId(),Product.class);
		System.out.println("product >>"+product);
		user_Product.setProduct(product);
		user_Product.setUser(user);
		return user_Product;
	}

	@Override
	public List<User_Product> getuserproductlist() {
		List<User_Product>al=new ArrayList<>(); 
		User_Product user_Product=new User_Product();
		List<User> user1= daoInterface.findAll();
		System.out.println("user>>"+user1);
		for (User user : user1) {
		Product product= resttemplate.getForObject("http://localhost:8080/GetProductById/"+user.getProcudtId(),Product.class);
		System.out.println("product >>"+product);
		user_Product.setProduct(product);
		user_Product.setUser(user);	
		al.add(user_Product);
		}
		
				
		return al;
	}

	}
