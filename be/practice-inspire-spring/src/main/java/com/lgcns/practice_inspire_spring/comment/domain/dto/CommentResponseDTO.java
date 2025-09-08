package com.lgcns.practice_inspire_spring.comment.domain.dto;

import com.lgcns.practice_inspire_spring.comment.domain.entity.CommentEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentResponseDTO {
    
    private Integer commentId;
    private String comment;
    //FK
    private Integer blogId;

    public static CommentResponseDTO fromEntity(CommentEntity entity){

        return CommentResponseDTO.builder()
                .commentId(entity.getCommentId())
                .comment(entity.getComment())
                .blogId(entity.getBlog().getBlogId())
                .build();
    }
}
