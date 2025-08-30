package com.lgcns.inspire_restspring.rest.blog.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
// auto wired를 하려면 setter가 있어야함
@Setter
@Getter 
public class BlogRequestDTO {
    @Schema(description = "블로그 식별자", example = "1")
    private Integer id;
    @Schema(description = "블로그 제목", example = "스프링 잼잼")
    private String title;
    @Schema(description = "블로그 내용", example = "스프링 노잼잼")
    private String content;
}
