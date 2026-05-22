package dev.juanv.proyectointegrador.controller.admin;

import dev.juanv.proyectointegrador.model.constant.NewsState;
import dev.juanv.proyectointegrador.model.dto.NewsDTO;
import dev.juanv.proyectointegrador.model.entity.News;
import dev.juanv.proyectointegrador.service.NewsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class AdminNewsController {

    private final NewsService service;

    public AdminNewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public String list(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(required = false) NewsState state,
            Model model
    ) {

        List<News> newsList;

        if (state != null) {
            newsList = service.findByState(state);
        } else if (!search.isBlank()) {
            newsList = service.search(search);
        } else {
            newsList = service.findAll();
        }

        model.addAttribute("newsList", newsList);
        model.addAttribute("search", search);
        model.addAttribute("selectedState", state);
        model.addAttribute("estados", NewsState.values());

        return "admin/news/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        NewsDTO dto = new NewsDTO(
                "",
                "",
                "",
                "",
                "",
                LocalDateTime.now(),
                NewsState.NEWS_STATE_DRAFT
        );

        model.addAttribute("newsRequest", dto);
        model.addAttribute("estados", NewsState.values());

        return "admin/news/create";
    }

    @PostMapping
    public String create(@ModelAttribute("newsRequest") NewsDTO dto) {
        service.create(dto);
        return "redirect:/news";
    }

    @GetMapping("/edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        Optional<News> result = service.findById(id);

        if (result.isEmpty()) {
            return "error/not-found";
        }

        model.addAttribute("news", result.get());
        model.addAttribute("estados", NewsState.values());

        return "admin/news/update";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute NewsDTO dto) {
        try {
            service.update(id, dto);
        } catch (EntityNotFoundException e) {
            return "error/not-found";
        }
        return "redirect:/news";
    }

    @GetMapping("/delete/{id}")
    public String deleteView(@PathVariable Long id, Model model) {
        Optional<News> result = service.findById(id);

        if (result.isEmpty()) {
            return "error/not-found";
        }

        model.addAttribute("news", result.get());
        return "admin/news/delete";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/news";
    }

}
