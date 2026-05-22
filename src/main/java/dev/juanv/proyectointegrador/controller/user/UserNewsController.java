package dev.juanv.proyectointegrador.controller.user;

import dev.juanv.proyectointegrador.model.entity.News;
import dev.juanv.proyectointegrador.service.NewsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/noticias")
public class UserNewsController {

    private final NewsService service;

    public UserNewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("newsList", service.findAll());
        return "user/news/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Optional<News> result = service.findById(id);

        if (result.isEmpty()) {
            return "error/not-found";
        }

        model.addAttribute("news", result.get());

        return "user/news/detail";
    }
}