package com.example.Visitor_Management_System.Controller;


import com.example.Visitor_Management_System.DTO.VisitorDTO;
import com.example.Visitor_Management_System.Entity.Visit;
import com.example.Visitor_Management_System.Service.VisitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.awt.*;

@RestController
@RequestMapping(value = "/api/v1/visitor", produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }


    @GetMapping
    public ResponseEntity<List<VisitorDTO>> getALLVisitors() {
        return ResponseEntity.ok(visitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitorDTO> getVisitor(@PathVariable(name = "id") Long id) {

        VisitorDTO visitor = visitService.getById(id);

        if (visitor != null)
            return ResponseEntity.ok(visitor);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    @PostMapping
    public ResponseEntity<Long> addVisitor(@RequestBody @Valid final VisitorDTO visitorDTO) {

        final Long createdId = visitService.createVisitor(visitorDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitorById(@PathVariable(name = "id") @Valid Long id){
         visitService.deleteById(id);
         return ResponseEntity.noContent().build();
    }
}
