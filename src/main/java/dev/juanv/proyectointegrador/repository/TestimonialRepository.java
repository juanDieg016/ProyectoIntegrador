package dev.juanv.proyectointegrador.repository;

import dev.juanv.proyectointegrador.model.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
}