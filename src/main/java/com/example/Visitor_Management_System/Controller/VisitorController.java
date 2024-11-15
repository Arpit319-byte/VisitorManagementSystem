package com.example.Visitor_Management_System.Controller;

import com.example.Visitor_Management_System.DTO.VisitorDTO;
import com.example.Visitor_Management_System.Service.VisitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/visitor")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    private ResponseEntity<List<VisitorDTO>> getVisitors(){
        return ResponseEntity.ok(visitorService.findAllVisitor());
    }

    @GetMapping("/{id}")
    private ResponseEntity<VisitorDTO> getVisitor(@PathVariable(name = "id") Long id){
        VisitorDTO visitorDTO = visitorService.getVisitorById(id);

        if(visitorDTO != null){
            return ResponseEntity.ok(visitorDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    private ResponseEntity<Long> addVisitor(@RequestBody @Valid VisitorDTO visitorDTO){
        return ResponseEntity.ok(visitorService.addVisitor(visitorDTO));
    }

    @PutMapping("/{id}")
    private ResponseEntity<VisitorDTO> updateVisitor(@PathVariable(name = "id") Long id,@RequestBody @Valid VisitorDTO visitorDTO){
        VisitorDTO updatedVisitor = visitorService.updateVisitor(id,visitorDTO);

        if(updatedVisitor != null){
            return ResponseEntity.ok(updatedVisitor);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteVisitor(@PathVariable(name = "id") Long id){
        VisitorDTO visitorDTO = visitorService.getVisitorById(id);

        if(visitorDTO != null){
            visitorService.deleteVisitor(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
