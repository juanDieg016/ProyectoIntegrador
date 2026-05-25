package dev.juanv.proyectointegrador.repository;

import dev.juanv.proyectointegrador.model.constant.NewsState;
import dev.juanv.proyectointegrador.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
            String title,
            String author
    );

    List<News> findByState(NewsState state);
    List<News> findTop3ByStateOrderByPublicationDateDesc(NewsState state);
}