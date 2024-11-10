package com.example.Visitor_Management_System.Controller;


import com.example.Visitor_Management_System.DTO.VisitDTO;
import com.example.Visitor_Management_System.Service.VisitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/visit", produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }


    @GetMapping
    public ResponseEntity<List<VisitDTO>> getALLVisits() {
        return ResponseEntity.ok(visitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDTO> getVisit(@PathVariable(name = "id") Long id) {

        VisitDTO visit = visitService.getById(id);

        if (visit != null)
            return ResponseEntity.ok(visit);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    @PostMapping
    public ResponseEntity<Long> addVisit(@RequestBody @Valid final VisitDTO visitDTO) {

        final Long createdId = visitService.createVisit(visitDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitDTO> updateVisit(@PathVariable(name = "id") @Valid Long id, @RequestBody @Valid VisitDTO visitDTO) {
        VisitDTO updatedVisit = visitService.updateVisit(visitDTO);

        if (updatedVisit != null)
            return ResponseEntity.ok(updatedVisit);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitById(@PathVariable(name = "id") @Valid Long id){
         visitService.deleteById(id);
         return ResponseEntity.noContent().build();
    }
}
