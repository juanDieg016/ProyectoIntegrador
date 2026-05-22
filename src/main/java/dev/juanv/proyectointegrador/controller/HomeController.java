package dev.juanv.proyectointegrador.controller;

import dev.juanv.proyectointegrador.model.entity.News;
import dev.juanv.proyectointegrador.service.NewsService;
import dev.juanv.proyectointegrador.service.TestimonialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {

    private final NewsService newsService;
    private final TestimonialService testimonialService;

    public HomeController(
            NewsService newsService,
            TestimonialService testimonialService
    ) {
        this.newsService = newsService;
        this.testimonialService = testimonialService;
    }

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute(
                "newsList",
                newsService.findAll()
        );

        model.addAttribute(
                "testimonials",
                testimonialService.findAll()
        );

        return "index";
    }

    @GetMapping("/sobre-nosotros")
    public String getAbout() {

        return "about";
    }



    @GetMapping("/login")
    public String getLogin() {

        return "auth/login";
    }

    @GetMapping("/admin")
    public String getDashboard() {

        return "admin/dashboard";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<News> result = newsService.findById(id);
        if(result.isEmpty()) {
            return "error/not-found";
        }
        model.addAttribute("news", result.get());
        return "user/news/detail";
    }
}