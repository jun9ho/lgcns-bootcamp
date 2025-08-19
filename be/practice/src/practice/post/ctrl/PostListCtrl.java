package practice.post.ctrl;

import java.util.List;

import practice.post.domain.dto.PostResponseDTO;
import practice.post.service.PostService;

public class PostListCtrl {
    private PostService service;
    public PostListCtrl(){
    }

    public PostListCtrl(PostService service) {
        this.service = service;
    }

    public List<PostResponseDTO> list(){
        System.out.println(">>>post list ctrl list");
        return service.selectService();
    }
}
