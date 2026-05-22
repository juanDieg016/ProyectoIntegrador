package dev.juanv.proyectointegrador.controller.user;

import dev.juanv.proyectointegrador.model.constant.ContactRequestPurpose;
import dev.juanv.proyectointegrador.model.dto.ContactRequestDTO;
import dev.juanv.proyectointegrador.service.ContactRequestService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacto")
public class UserContactRequestController {

    private final ContactRequestService service;

    public UserContactRequestController(ContactRequestService service) {
        this.service = service;
    }
    @GetMapping
    public String getContactTemplate(Model model) {

        model.addAttribute("contactRequest", new ContactRequestDTO("", "", "", null)); // Erro con el dto al quitar los valores vacios y se rompe ya que el controlasdor pide un conbbstructor vacio para el formulario
        model.addAttribute("finalidades", ContactRequestPurpose.values());
        return "contact";
    }
    @PostMapping
    public String sendContactRequest(@ModelAttribute("contactRequest") ContactRequestDTO dto) {
        service.create(dto);
        return "redirect:/contacto?success";
    }
}