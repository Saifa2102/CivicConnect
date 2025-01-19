package com.example.CivicConnect.repository;

import com.example.CivicConnect.entity.Report_Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Report_Issue_Repository extends JpaRepository <Report_Issue,Long> {
}
