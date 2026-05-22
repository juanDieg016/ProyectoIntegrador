package dev.juanv.proyectointegrador.controller.user;

import dev.juanv.proyectointegrador.service.TestimonialService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/testimonios")
public class UserTestimonialController {

    private final TestimonialService service;

    public UserTestimonialController(TestimonialService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {

        model.addAttribute("testimonials", service.findAll());

        return "user/testimonials/list";
    }
}