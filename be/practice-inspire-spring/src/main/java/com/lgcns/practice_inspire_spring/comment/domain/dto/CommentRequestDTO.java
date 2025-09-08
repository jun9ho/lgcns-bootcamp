package com.lgcns.practice_inspire_spring.comment.domain.dto;

import com.lgcns.practice_inspire_spring.blog.domain.entity.BlogEntity;
import com.lgcns.practice_inspire_spring.comment.domain.entity.CommentEntity;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class CommentRequestDTO {
    
    @Schema(description="댓글 내용", example = "안녕하세요." )
    private String comment;

    //FK
    private Integer blogId;

    public CommentEntity toEntity(BlogEntity blog){
        return CommentEntity.builder()
                .comment(this.comment)
                .blog(blog)
                .build();
    }
}
