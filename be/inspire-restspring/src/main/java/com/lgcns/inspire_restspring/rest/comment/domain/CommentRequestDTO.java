package com.lgcns.inspire_restspring.rest.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {
    private int id;
    private String comment;
    private int blog_id;
}
