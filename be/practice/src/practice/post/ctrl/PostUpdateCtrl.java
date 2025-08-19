package practice.post.ctrl;

import java.util.Optional;

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
        
        Optional<PostResponseDTO> result = service.selectService(id);
        
        return 1;

    }
}
