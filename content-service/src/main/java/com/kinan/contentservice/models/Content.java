package com.kinan.contentservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Eren
 **/
@Document(collection = "contents")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {
    @Id
    private String id;
    private String title;
    private Integer year;
    private String image;
    private List<String> genresIds = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();
}
