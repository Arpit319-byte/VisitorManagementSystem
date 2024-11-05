package com.example.Visitor_Management_System.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Visit {

    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitId;

    private Long visitorId;

    private Long hostId;

    @Column(nullable = false)
    private String purposeOfVisit;

    @Column(nullable = false)
    private LocalDateTime checkInTime;

    @Column(nullable = false)
    private LocalDateTime checkOutTime;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateAt;
}
