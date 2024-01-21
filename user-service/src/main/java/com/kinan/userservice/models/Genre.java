package com.kinan.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genre {
    private String id;
    private String name;
    private List<String> contentsIds = new ArrayList<>();
}
