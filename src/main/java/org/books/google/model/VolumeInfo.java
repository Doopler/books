package org.books.google.model;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
public class VolumeInfo {

    private static String ISBN_TYPE = "ISBN_13";
    private static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat sdfFull = new SimpleDateFormat("yyyy-MM-dd");

    private List<IndustryIdentifier> industryIdentifiers;
    private String title;
    private String subtitle;
    private String publisher;
    private String publishedDate;
    private String description;
    private Integer pageCount;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private Double averageRating;
    private List<String> authors;
    private List<String> categories;


    public String getIsbn(){
        if(Objects.isNull(industryIdentifiers)){
            return null;
        }

        return industryIdentifiers.stream()
                .filter(identifier -> ISBN_TYPE.equals(identifier.getType()))
                .map(IndustryIdentifier::getIdentifier)
                .findFirst()
                .orElse(null);
    }

    public Long getPublishedDate(){
        if(Objects.isNull(publishedDate)){
            return null;
        }
        Date date = null;

        try {
            date = sdfFull.parse(publishedDate);
        } catch (ParseException e) {
            try {
                date = sdfYear.parse(publishedDate);
            } catch (ParseException f) {
                f.printStackTrace();
            }
        }

        return Optional.ofNullable(date)
                .map(Date::getTime)
                .orElse(null);

    }

}