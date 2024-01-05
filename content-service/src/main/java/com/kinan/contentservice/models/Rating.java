package com.kinan.contentservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eren
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private Double stars;
    private String idUser;
}
