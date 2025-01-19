package com.example.CivicConnect.repository;

import com.example.CivicConnect.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Register_Repository extends JpaRepository <Register ,Long> {


}
