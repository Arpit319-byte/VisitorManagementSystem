package com.example.Visitor_Management_System.Repository;

import com.example.Visitor_Management_System.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
