package com.kinan.contentservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Document(collection = "genres")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genre {
    @Id
    private String id;
    private String name;
    private List<String> contentsIds = new ArrayList<>();
}
