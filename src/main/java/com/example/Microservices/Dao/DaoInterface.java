package com.example.Microservices.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Microservices.Entity.User;
@Repository
public interface DaoInterface extends JpaRepository<User,String> {

	
}
