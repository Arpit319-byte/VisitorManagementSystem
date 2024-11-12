package com.example.Visitor_Management_System.Entity;

import com.example.Visitor_Management_System.DTO.HostStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Host {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostId;

    @Column(nullable = false)
    private String hostName;

    @OneToOne
    @JoinColumn(name = "flat_id", referencedColumnName = "flatId", nullable = false)
    private Flat flat;

    @Column(nullable = false, unique = true)
    private String hostEmail;

    @Column(nullable = false, unique = true)
    private String hostPhoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HostStatus status;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
