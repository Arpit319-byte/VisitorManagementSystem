package com.example.Visitor_Management_System.Service;

import com.example.Visitor_Management_System.DTO.HostDTO;
import com.example.Visitor_Management_System.Entity.Host;
import com.example.Visitor_Management_System.Repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HostService {

    private final HostRepository hostRepository;

    @Autowired
    public HostService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public List<HostDTO> findAll() {
        List<Host> hosts = hostRepository.findAll();
        return hosts.stream()
                .map(host -> mapToDTO(host, new HostDTO()))
                .toList();
    }

    public HostDTO getById(Long id) {
        Host host = hostRepository.findById(id).orElse(null);
        if (host != null) {
            return mapToDTO(host, new HostDTO());
        }
        return null;
    }

    @Transactional
    public Long addHost(HostDTO hostDTO) {
        Host host = mapToEntity(hostDTO, new Host());
        return hostRepository.save(host).getHostId();
    }

    @Transactional
    public HostDTO updateHost(HostDTO hostDTO) {
        Host newHost= mapToEntity(hostDTO, new Host());

        if(hostRepository.existsById(newHost.getHostId())) {
            return mapToDTO(hostRepository.save(newHost), new HostDTO());
        }
        return null;
    }

    @Transactional
    public void deleteHost(Long id) {
        hostRepository.deleteById(id);
    }

    public HostDTO mapToDTO(Host host, HostDTO hostDTO) {
        hostDTO.setId(host.getHostId());
        hostDTO.setName(host.getHostName());
        hostDTO.setEmail(host.getHostEmail());
        hostDTO.setPhoneNumber(host.getHostPhoneNumber());
        hostDTO.setFlat(host.getFlat());
        hostDTO.setStatus(host.getStatus());
        return hostDTO;
    }

    public Host mapToEntity(HostDTO hostDTO, Host host) {
        host.setHostId(hostDTO.getId());
        host.setHostName(hostDTO.getName());
        host.setHostEmail(hostDTO.getEmail());
        host.setHostPhoneNumber(hostDTO.getPhoneNumber());
        host.setFlat(hostDTO.getFlat());
        host.setStatus(hostDTO.getStatus());
        return host;
    }
}
