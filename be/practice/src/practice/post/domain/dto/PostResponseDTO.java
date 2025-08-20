package practice.post.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class PostResponseDTO implements Serializable{
    
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private int viewCnt;
}
