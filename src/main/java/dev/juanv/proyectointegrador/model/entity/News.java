package dev.juanv.proyectointegrador.model.entity;

import dev.juanv.proyectointegrador.model.constant.NewsState;
import dev.juanv.proyectointegrador.model.dto.NewsDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "image_url")
    private String imageUrl;

    private String author;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @Enumerated(EnumType.STRING)
    private NewsState state;

    public News() {}



    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public NewsState getState() {
        return state;
    }

    public void setState(NewsState state) {
        this.state = state;
    }

    public void replaceFieldsWith(NewsDTO dto) {
        setTitle(dto.title());
        setSummary(dto.summary());
        setContent(dto.content());
        setImageUrl(dto.imageUrl());
        setAuthor(dto.author());
        setPublicationDate(dto.publicationDate());
        setState(dto.state());
    }
}