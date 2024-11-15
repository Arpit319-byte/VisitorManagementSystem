package com.example.Visitor_Management_System.Controller;

import com.example.Visitor_Management_System.DTO.VisitDTO;
import com.example.Visitor_Management_System.DTO.VisitorDTO;
import com.example.Visitor_Management_System.Service.VisitService;
import com.example.Visitor_Management_System.Service.VisitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gatekeeper")
public class GateKeeperPanelController {

    public final VisitService visitService;
    public final VisitorService visitorService;

    @Autowired
    public GateKeeperPanelController(VisitService visitService, VisitorService visitorService) {
        this.visitService = visitService;
        this.visitorService = visitorService;
    }

    @PostMapping("/createVisit")
    public ResponseEntity<Long> createVisit(@RequestBody @Valid VisitDTO visitDTO){
        Long createdId=visitService.createVisit(visitDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PostMapping("/createVisitor")
    public ResponseEntity<Long> createVisitor(@RequestBody @Valid VisitorDTO visitorDTO){
        Long createdId=visitorService.addVisitor(visitorDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/markEntry/{id}")
    public ResponseEntity<Void> markEntry(@PathVariable(name="id") Long id){
        visitService.updateInTime(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/markExist/{id}")
    public ResponseEntity<Void> markExist(@PathVariable(name="id") Long id){
        visitService.updateOutTime(id);
        return ResponseEntity.ok().build();
    }
}
