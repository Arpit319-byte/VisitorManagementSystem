package com.example.Visitor_Management_System.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitorDTO {

    private Long id;

    @NotNull
    @Size(max=255)
    private String name;

    @NotNull
    @Size(max=255)
    private String email;

    @NotNull
    @Size(max=255)
    private String PhoneNumber;

    @NotNull
    @Size(max=255)
    private String idProof;

    @NotNull
    @Size(max=255)
    private String idProofNumber;


}
