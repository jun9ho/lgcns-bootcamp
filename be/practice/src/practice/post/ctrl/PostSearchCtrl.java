package practice.post.ctrl;

import java.util.List;
import java.util.Optional;

import practice.post.domain.dto.PostResponseDTO;
import practice.post.service.PostService;

public class PostSearchCtrl {
    
    private PostService service;

    public PostSearchCtrl() {
    }

    public PostSearchCtrl(PostService service){
        this.service = service;
    }

    public Optional<List<PostResponseDTO>> search(String writer){
        System.out.println(">>>> post ctrl search : params writer "+writer);
        return service.searchService(writer);
    }
}
