package com.example.Visitor_Management_System.Controller;


import com.example.Visitor_Management_System.DTO.HostDTO;
import com.example.Visitor_Management_System.Entity.Host;
import com.example.Visitor_Management_System.Service.HostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/host")
public class HostController {

    private final HostService hostService;

    @Autowired
    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping
    public ResponseEntity<List<HostDTO>> getHosts(){
        return ResponseEntity.ok(hostService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HostDTO> getHost(Long id){
        return ResponseEntity.ok(hostService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Long> addHost(@RequestBody @Valid HostDTO hostDTO){
        return ResponseEntity.ok(hostService.addHost(hostDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HostDTO> updateHost(@PathVariable(name = "id") Long id, @RequestBody @Valid HostDTO hostDTO){

       HostDTO updatedHost = hostService.updateHost(hostDTO);

       if (updatedHost != null){
           return ResponseEntity.ok(updatedHost);
       }
         return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable(name = "id") Long id){

        HostDTO hostDTO = hostService.getById(id);
        if (hostDTO != null){
            hostService.deleteHost(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
