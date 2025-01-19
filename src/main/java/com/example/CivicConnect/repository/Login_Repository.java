package com.example.CivicConnect.repository;

import com.example.CivicConnect.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Login_Repository extends JpaRepository<Login,Long> {

}
