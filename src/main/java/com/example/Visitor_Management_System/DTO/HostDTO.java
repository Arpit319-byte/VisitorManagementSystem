package com.example.Visitor_Management_System.DTO;

import com.example.Visitor_Management_System.Entity.Flat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HostDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    private Flat flat;

    @NotNull
    @Size(max = 255)
    private String phoneNumber;

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    private HostStatus status;

}
