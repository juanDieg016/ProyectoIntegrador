package dev.juanv.proyectointegrador.service;

import dev.juanv.proyectointegrador.model.constant.NewsState;
import dev.juanv.proyectointegrador.model.dto.NewsDTO;
import dev.juanv.proyectointegrador.model.entity.News;
import dev.juanv.proyectointegrador.repository.NewsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public List<News> findAll() {
        return repository.findAll();
    }

    public void create(NewsDTO dto) {
        repository.save(dto.toEntity());
    }

    public Optional<News> findById(Long id) {
        return repository.findById(id);
    }



    public void update(Long id, NewsDTO dto) throws EntityNotFoundException {
        News entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Noticia no encontrada con id " + id));

        entity.replaceFieldsWith(dto);

        repository.save(entity);
    }

    public void delete(Long id) throws EntityNotFoundException {
        News entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Noticia no encontrada con id " + id));

        repository.delete(entity);
    }
    public List<News> search(String search) {

        return repository
                .findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                        search,
                        search
                );
    }

    public List<News> findByState(NewsState state) {

        return repository.findByState(state);
    }
}