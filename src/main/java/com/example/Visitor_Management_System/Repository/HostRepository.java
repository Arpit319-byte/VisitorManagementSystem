package com.example.Visitor_Management_System.Repository;

import com.example.Visitor_Management_System.Entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
