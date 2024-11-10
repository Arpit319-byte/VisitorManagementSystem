package com.example.Visitor_Management_System.Repository;

import com.example.Visitor_Management_System.Entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {

}
