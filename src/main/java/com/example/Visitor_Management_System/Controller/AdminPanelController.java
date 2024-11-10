package com.example.Visitor_Management_System.Controller;

import com.example.Visitor_Management_System.DTO.HostDTO;
import com.example.Visitor_Management_System.Entity.Address;
import com.example.Visitor_Management_System.Service.HostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminPanelController {

    private HostService hostService;

    @Autowired
    public AdminPanelController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public ResponseEntity<Long> addHost(@RequestBody @Valid final HostDTO hostDTO){
        Long createdId = hostService.addHost(hostDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }


}
