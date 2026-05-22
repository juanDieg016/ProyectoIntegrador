package dev.juanv.proyectointegrador.controller.admin;

import dev.juanv.proyectointegrador.model.dto.TestimonialDTO;
import dev.juanv.proyectointegrador.model.entity.Testimonial;
import dev.juanv.proyectointegrador.service.TestimonialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/testimonials")
public class AdminTestimonialController {

    private final TestimonialService service;

    public AdminTestimonialController(TestimonialService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("testimonials", service.findAll());
        return "admin/testimonials/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("testimonialRequest", new TestimonialDTO(null, null, null, null));
        return "admin/testimonials/create";
    }

    @PostMapping
    public String create(@ModelAttribute("testimonialRequest") TestimonialDTO dto) {
        service.create(dto);
        return "redirect:/testimonials";
    }

    @GetMapping("/edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        Optional<Testimonial> result = service.findById(id);

        if (result.isEmpty()) {
            return "error/not-found";
        }

        model.addAttribute("testimonial", result.get());
        return "admin/testimonials/update";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute TestimonialDTO dto) {
        try {
            service.update(id, dto);
        } catch (EntityNotFoundException e) {
            return "error/not-found";
        }

        return "redirect:/testimonials";
    }

    @GetMapping("/delete/{id}")
    public String deleteView(@PathVariable Long id, Model model) {
        Optional<Testimonial> result = service.findById(id);

        if (result.isEmpty()) {
            return "error/not-found";
        }

        model.addAttribute("testimonial", result.get());
        return "admin/testimonials/delete";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/testimonials";
    }
}