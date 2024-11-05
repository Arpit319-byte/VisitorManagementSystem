package com.example.Visitor_Management_System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private String l1;

    @Column(nullable = false)
    private String l2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String pinCode;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
