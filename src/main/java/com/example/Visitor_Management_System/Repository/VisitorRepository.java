package com.example.Visitor_Management_System.Repository;

import com.example.Visitor_Management_System.Entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
