package dev.juanv.proyectointegrador.model.dto;

import dev.juanv.proyectointegrador.model.constant.ContactRequestPurpose;
import dev.juanv.proyectointegrador.model.entity.ContactRequest;

public record ContactRequestDTO(
        String name,
        String email,
        String phone,
        ContactRequestPurpose purpose
) {

    public ContactRequest toEntity() {
        ContactRequest entity = new ContactRequest();

        entity.setName(name);
        entity.setEmail(email);
        entity.setPhone(phone);
        entity.setPurpose(purpose);

        return entity;
    }
}