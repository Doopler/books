package org.books.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.books.google.model.VolumeInfo;

import java.util.List;

@Data
@NoArgsConstructor
public class Book {

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Long publishedDate;
    private String description;
    private Integer pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private Double averageRating;
    private List<String> authors;
    private List<String> categories;


    public Book(VolumeInfo volumeInfo) {
        this.isbn = volumeInfo.getIsbn();
        this.title = volumeInfo.getTitle();
        this.subtitle = volumeInfo.getSubtitle();
        this.publisher = volumeInfo.getPublisher();
        this.publishedDate = volumeInfo.getPublishedDate();
        this.description = volumeInfo.getDescription();
        this.pageCount = volumeInfo.getPageCount();
        this.thumbnailUrl = volumeInfo.getImageLinks().getThumbnail();
        this.language = volumeInfo.getLanguage();
        this.previewLink = volumeInfo.getPreviewLink();
        this.averageRating = volumeInfo.getAverageRating();
        this.authors = volumeInfo.getAuthors();
        this.categories = volumeInfo.getCategories();
    }

}