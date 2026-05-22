package dev.juanv.proyectointegrador.model.dto;

import dev.juanv.proyectointegrador.model.constant.NewsState;
import dev.juanv.proyectointegrador.model.entity.News;

import java.time.LocalDateTime;

public record NewsDTO(
        String title,
        String summary,
        String content,
        String imageUrl,
        String author,
        LocalDateTime publicationDate,
        NewsState state
) {

    public News toEntity() {
        News news = new News();

        news.setTitle(title);
        news.setSummary(summary);
        news.setContent(content);
        news.setImageUrl(imageUrl);
        news.setAuthor(author);
        news.setPublicationDate(publicationDate);
        news.setState(state);

        return news;
    }
}