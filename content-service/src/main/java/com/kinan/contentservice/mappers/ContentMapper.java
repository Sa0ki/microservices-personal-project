package com.kinan.contentservice.mappers;

import com.kinan.contentservice.dtos.ContentDto;
import com.kinan.contentservice.models.Content;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Component
public class ContentMapper {
    private final static ModelMapper contentMapper = new ModelMapper();
    public static ContentDto fromContentToContentDto(Content content){
        return contentMapper.map(content, ContentDto.class);
    }
    public static List<ContentDto> fromContentsToContentDtos(List<Content> contents){
        List<ContentDto> contentDtos = new ArrayList<>();
        contents.forEach(c -> contentDtos.add(fromContentToContentDto(c)));
        return contentDtos;
    }
}
