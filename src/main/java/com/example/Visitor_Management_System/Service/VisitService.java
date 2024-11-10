package com.example.Visitor_Management_System.Service;

import com.example.Visitor_Management_System.DTO.VisitDTO;
import com.example.Visitor_Management_System.DTO.VisitorDTO;
import com.example.Visitor_Management_System.Entity.Visit;
import com.example.Visitor_Management_System.Entity.Visitor;
import com.example.Visitor_Management_System.Repository.VisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.awt.*;


@Service
public class VisitService {

    private static final Logger logger = LoggerFactory.getLogger(VisitService.class);

    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }


    public List<VisitDTO> findAll() {
        logger.info("Fetching all visits");
        List<Visit> visits=visitRepository.findAll(Sort.by("id"));
        return visits.stream()
                .map(visit -> mapToDTO(visit, new VisitDTO()))
                .toList();
    }

    public VisitDTO getById(Long id) {
        logger.info("Fetching visit with id: {}", id);
        return visitRepository.findById(id)
                .map(visit -> mapToDTO(visit, new VisitDTO()))
                .orElse(null);
    }

    @Transactional
    public Long createVisit(VisitDTO visitDTO) {
        logger.info("Creating new visit");
        Visit visit = mapToEntity(visitDTO, new Visit());
        return visitRepository.save(visit).getVisitId();
    }

    @Transactional
    public VisitDTO updateVisit(VisitDTO visitDTO) {
        logger.info("Updating visit with id: {}", visitDTO.getId());
        Visit visit = visitRepository.findById(visitDTO.getId()).orElseThrow();
        visit = mapToEntity(visitDTO, visit);
        return mapToDTO(visitRepository.save(visit), visitDTO);
    }

    @Transactional
    public void deleteById(Long id) {
        logger.info("Deleting visit with id: {}", id);
        visitRepository.deleteById(id);
    }

     private VisitDTO mapToDTO(final Visit visit, final VisitDTO visitDTO){
         visitDTO.setId(visit.getVisitId());
         visitDTO.setHostId(visit.getVisitId());
         visitDTO.setVisitorId(visit.getVisitId());
         visitDTO.setFlatNumber(visit.getFlatNumber());
         visitDTO.setPurpose(visit.getPurposeOfVisit());
         visitDTO.setVisitStatus(visit.getVisitStatus());
         visitDTO.setInTime(visit.getCheckInTime());
         visitDTO.setOutTime(visit.getCheckOutTime());
         return visitDTO;
     }

        private Visit mapToEntity(final VisitDTO visitDTO, final Visit visit){
            visit.setVisitId(visitDTO.getId());
            visit.setVisitId(visitDTO.getHostId());
            visit.setVisitId(visitDTO.getVisitorId());
            visit.setFlatNumber(visitDTO.getFlatNumber());
            visit.setPurposeOfVisit(visitDTO.getPurpose());
            visit.setVisitStatus(visitDTO.getVisitStatus());
            visit.setCheckInTime(visitDTO.getInTime());
            visit.setCheckOutTime(visitDTO.getOutTime());
            return visit;
        }

}
