package com.example.Visitor_Management_System.Service;
import com.example.Visitor_Management_System.DTO.VisitorDTO;
import com.example.Visitor_Management_System.Entity.Visitor;
import com.example.Visitor_Management_System.Repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public List<VisitorDTO> findAllVisitor() {
        List<Visitor> visitors= visitorRepository.findAll();
        return visitors.stream()
                .map(visitor -> mapToDTO(visitor, new VisitorDTO()))
                .toList();
    }

    public VisitorDTO getVisitorById(Long id) {
        Visitor visitor= visitorRepository.findById(id).orElse(null);
        if(visitor != null){
            return mapToDTO(visitor, new VisitorDTO());
        }
        return null;
    }


    @Transactional
    public Long addVisitor(VisitorDTO visitorDTO) {
        Visitor visitor = mapToEntity(new Visitor(), visitorDTO);
        return visitorRepository.save(visitor).getId();

    }

    @Transactional
    public VisitorDTO updateVisitor(Long id,VisitorDTO visitorDTO) {

        Visitor visitor=visitorRepository.findById(id).orElse(null);

        if(visitor != null){
            visitor = mapToEntity(visitor, visitorDTO);
            visitorRepository.save(visitor);
            return mapToDTO(visitor, new VisitorDTO());
        }
        return null;
    }

    @Transactional
    public void deleteVisitor(Long id) {
        visitorRepository.deleteById(id);
    }

    public VisitorDTO mapToDTO(Visitor visitor, VisitorDTO visitorDTO){
        visitorDTO.setId(visitor.getId());
        visitorDTO.setName(visitor.getName());
        visitorDTO.setEmail(visitor.getEmail());
        visitorDTO.setPhoneNumber(visitor.getPhoneNumber());
        visitorDTO.setIdProof(visitor.getIdProof());
        visitorDTO.setIdProofNumber(visitor.getIdProofNumber());
        return visitorDTO;
    }

    public Visitor mapToEntity(Visitor visitor, VisitorDTO visitorDTO){
        visitor.setId(visitorDTO.getId());
        visitor.setName(visitorDTO.getName());
        visitor.setEmail(visitorDTO.getEmail());
        visitor.setPhoneNumber(visitorDTO.getPhoneNumber());
        visitor.setIdProof(visitorDTO.getIdProof());
        visitor.setIdProofNumber(visitorDTO.getIdProofNumber());
        return visitor;
    }

}
