package dev.juanv.proyectointegrador.service;

import dev.juanv.proyectointegrador.model.dto.ContactRequestDTO;
import dev.juanv.proyectointegrador.model.entity.ContactRequest;
import dev.juanv.proyectointegrador.repository.ContactRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactRequestService {

    private final ContactRequestRepository repository;

    public ContactRequestService(ContactRequestRepository repository) {
        this.repository = repository;
    }

    public List<ContactRequest> findAll() {
        return repository.findAll();
    }

    public void create(ContactRequestDTO dto) {
        repository.save(dto.toEntity());
    }

    public Optional<ContactRequest> findById(Long id) {
        return repository.findById(id);
    }

    public void update(Long id, ContactRequestDTO dto) throws EntityNotFoundException {
        ContactRequest entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solicitud no encontrada con id " + id));

        entity.replaceFieldsWith(dto);

        repository.save(entity);
    }
    public void delete(Long id) throws EntityNotFoundException {
        ContactRequest entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solicitud no encontrada con id " + id));

        repository.delete(entity);
    }
}