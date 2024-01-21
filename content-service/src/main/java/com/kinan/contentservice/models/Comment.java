package com.kinan.contentservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author Eren
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private String message;
    private String idUser;
}
