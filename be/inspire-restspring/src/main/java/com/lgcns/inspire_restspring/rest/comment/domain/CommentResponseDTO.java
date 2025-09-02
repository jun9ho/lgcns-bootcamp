package com.lgcns.inspire_restspring.rest.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDTO {

    private int id;
    private int blog_id;
    private String comment;

}
