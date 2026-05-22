package dev.juanv.proyectointegrador.service;

import dev.juanv.proyectointegrador.model.dto.TestimonialDTO;
import dev.juanv.proyectointegrador.model.entity.Testimonial;
import dev.juanv.proyectointegrador.repository.TestimonialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestimonialService {

    private final TestimonialRepository repository;

    public TestimonialService(TestimonialRepository repository) {
        this.repository = repository;
    }

    public List<Testimonial> findAll() {
        return repository.findAll();
    }

    public void create(TestimonialDTO dto) {
        repository.save(dto.toEntity());
    }

    public Optional<Testimonial> findById(Long id) {
        return repository.findById(id);
    }

    public void update(Long id, TestimonialDTO dto) throws EntityNotFoundException {
        Testimonial entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimonio no encontrado con id " + id));

        entity.replaceFieldsWith(dto);

        repository.save(entity);
    }

    public void delete(Long id) throws EntityNotFoundException {
        Testimonial entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimonio no encontrado con id " + id));

        repository.delete(entity);
    }
}