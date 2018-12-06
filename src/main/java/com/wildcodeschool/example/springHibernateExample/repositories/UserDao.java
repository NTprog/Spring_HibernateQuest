package com.wildcodeschool.example.springHibernateExample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.example.springHibernateExample.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
}
