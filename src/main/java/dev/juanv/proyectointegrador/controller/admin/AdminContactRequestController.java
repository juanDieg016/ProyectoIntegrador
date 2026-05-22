package dev.juanv.proyectointegrador.controller.admin;

import dev.juanv.proyectointegrador.model.entity.ContactRequest;
import dev.juanv.proyectointegrador.service.ContactRequestService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/contact-request")
public class AdminContactRequestController {

    private final ContactRequestService service;

    public AdminContactRequestController(ContactRequestService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("contactRequests", service.findAll());
        return "admin/contact-request/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteView(@PathVariable Long id, Model model) {
        Optional<ContactRequest> result = service.findById(id);

        if (result.isEmpty()) {
            return "error/not-found";
        }

        model.addAttribute("contact", result.get());
        return "admin/contact-request/delete";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            return "error/not-found";
        }

        return "redirect:/contact-request";
    }

    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response) {

    }
}