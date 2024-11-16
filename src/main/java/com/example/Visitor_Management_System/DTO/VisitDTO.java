package com.example.Visitor_Management_System.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;

import java.time.LocalDateTime;

@Getter
@Setter
public class VisitDTO {


    private Long id;

    @NotNull
    private Long hostId;

    @NotNull
    private Long visitorId;

    @NotNull
    @Size(max = 255)
    private String flatNumber;

    @NotNull
    @Size(max = 255)
    private String purpose;

    private VisitStatus visitStatus;

    private LocalDateTime inTime;

    private LocalDateTime outTime;

}
