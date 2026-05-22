package dev.juanv.proyectointegrador.repository;

import dev.juanv.proyectointegrador.model.entity.ContactRequest;
import dev.juanv.proyectointegrador.model.constant.ContactRequestPurpose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

    List<ContactRequest> findByPurpose(ContactRequestPurpose purpose);

}