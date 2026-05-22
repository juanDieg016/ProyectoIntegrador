package dev.juanv.proyectointegrador.model.entity;

import dev.juanv.proyectointegrador.model.constant.ContactRequestPurpose;
import dev.juanv.proyectointegrador.model.dto.ContactRequestDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_requests")
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 100)
    private String email;

    @Column(nullable = false,length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContactRequestPurpose purpose;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    public ContactRequest() {
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ContactRequestPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(ContactRequestPurpose purpose) {
        this.purpose = purpose;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    public void replaceFieldsWith(ContactRequestDTO dto) {
        setName(dto.name());
        setEmail(dto.email());
        setPhone(dto.phone());
        setPurpose(dto.purpose());
    }
}