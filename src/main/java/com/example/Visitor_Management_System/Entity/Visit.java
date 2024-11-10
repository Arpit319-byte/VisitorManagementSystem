package com.example.Visitor_Management_System.Entity;


import com.example.Visitor_Management_System.DTO.VisitStatus;
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

    @ManyToOne
    @JoinColumn(name = "visitorId",referencedColumnName = "visitorId",nullable = false)
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "hostId",referencedColumnName = "hostId",nullable = false)
    private Host host;

    @Column(nullable = false)
    private String flatNumber;

    @Column(nullable = false)
    private String purposeOfVisit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VisitStatus visitStatus;

    @Column(nullable = false)
    private LocalDateTime checkInTime;

    @Column(nullable = false)
    private LocalDateTime checkOutTime;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
