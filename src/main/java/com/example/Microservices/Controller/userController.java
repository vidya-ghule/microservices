package com.example.Microservices.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Microservices.Entity.User;
import com.example.Microservices.Model.User_Product;
import com.example.Microservices.Service.ServiceInterface;




@RestController
@RequestMapping("/User")
public class userController {

	@Autowired
	ServiceInterface serviceInterface;

	@PostMapping("/Insertuser")

	public ResponseEntity<String> saveuser(@RequestBody User user)
	{
		try {

			String msg=this.serviceInterface.saveUser( user);

			return new ResponseEntity<>(msg,HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("user not save",HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//get user by username
	@GetMapping("/GetUserByUsername/{username}")
	public ResponseEntity<User> GetUserByUsername(@PathVariable String username) {
		try {
			User user= this.serviceInterface.getuserbyname(username);
	
		 return new ResponseEntity<User>(user,HttpStatus.OK);
		} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	//get userwith product by username
		@GetMapping("/GetUserwithproductUsername/{username}")
		public ResponseEntity<User_Product> GetUserwithproductUsername(@PathVariable String username) {
			try {
				User_Product user_Product= this.serviceInterface.GetUserwithproductUsername(username);
		
			 return new ResponseEntity<User_Product>(user_Product,HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		//get userwith product by all listrelated to productid
		@GetMapping("/getUserProductList")
		public ResponseEntity< List<User_Product>> getUserProductList() {
			try {
				List<User_Product> uplist= this.serviceInterface.getuserproductlist();
		
			 return new ResponseEntity<List<User_Product>>(uplist,HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		//get userwith product by all list
				@GetMapping("/getUserProductLists")
				public ResponseEntity< List<User_Product>> getUserProductLists() {
					try {
						List<User_Product> uplist= this.serviceInterface.getuserproductlist();
				
					 return new ResponseEntity<List<User_Product>>(uplist,HttpStatus.OK);
					} catch (Exception e) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
					
				}
	
}
