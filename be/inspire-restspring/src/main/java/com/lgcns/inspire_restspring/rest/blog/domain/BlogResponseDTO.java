package com.lgcns.inspire_restspring.rest.blog.domain;

import java.util.List;

import com.lgcns.inspire_restspring.rest.comment.domain.CommentResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponseDTO {
    private Integer id;
    private String title;
    private String content;

    List<CommentResponseDTO> comments;

}
