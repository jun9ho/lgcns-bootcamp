package com.lgcns.inspire_restspring.rest.blog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class BlogResponseDTO {
    private Integer id;
    private String title;
    private String content;
}
