package com.kinan.contentservice.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private String id;
    private String name;
    private List<ContentDto> contents = new ArrayList<>();
}
