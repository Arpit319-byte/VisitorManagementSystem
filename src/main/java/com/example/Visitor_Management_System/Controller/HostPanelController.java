package com.example.Visitor_Management_System.Controller;

import com.example.Visitor_Management_System.DTO.VisitDTO;
import com.example.Visitor_Management_System.Service.VisitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/host")
public class HostPanelController {

    public final VisitService visitService;

    @Autowired
    public HostPanelController(VisitService visitService){
        this.visitService=visitService;
    }

    @GetMapping("/allPendingVisits")
    public ResponseEntity<List<VisitDTO>> getAllPendingVisits(){
        return ResponseEntity.ok(visitService.findAllPendingVisits());
    }

    @PutMapping("/approveVisit/{visitId}")
    public ResponseEntity<Void> approveVisit(@PathVariable(name ="visitId") Long id){
        visitService.approveVisit(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rejectVisit/{visitId}")
    public ResponseEntity<Void> rejectVisit(@PathVariable(name ="visitId") Long id){
        visitService.rejectVisit(id);
        return ResponseEntity.ok().build();
    }
}
