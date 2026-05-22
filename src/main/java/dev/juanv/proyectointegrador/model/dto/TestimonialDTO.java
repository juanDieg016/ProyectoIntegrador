package dev.juanv.proyectointegrador.model.dto;

import dev.juanv.proyectointegrador.model.entity.Testimonial;

public record TestimonialDTO(
        String name,
        String photoUrl,
        String instagramUrl,
        String facebookUrl
) {

    public Testimonial toEntity() {
        Testimonial testimonial = new Testimonial();

        testimonial.setName(name);
        testimonial.setPhotoUrl(photoUrl);
        testimonial.setInstagramUrl(instagramUrl);
        testimonial.setFacebookUrl(facebookUrl);

        return testimonial;
    }
}