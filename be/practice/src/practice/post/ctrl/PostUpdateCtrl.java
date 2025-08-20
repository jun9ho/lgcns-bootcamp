package practice.post.ctrl;

import java.util.Optional;

import practice.post.domain.dto.PostRequestDTO;
import practice.post.domain.dto.PostResponseDTO;
import practice.post.service.PostService;

public class PostUpdateCtrl {
    
    private PostService service;

    public PostUpdateCtrl() {
    }
    public PostUpdateCtrl(PostService service) {
        this.service = service;
    }

    public int update(String title, String content, int id){

        System.out.println(">>>> post update : params title " + title + ", content " + content + ", id " + id);

                PostRequestDTO request = PostRequestDTO.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();

        return service.updateService(request);

    }
}
