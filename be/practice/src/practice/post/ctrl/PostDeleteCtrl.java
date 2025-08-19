package practice.post.ctrl;

import java.util.List;

import practice.post.domain.dto.PostResponseDTO;
import practice.post.service.PostService;

public class PostDeleteCtrl {

    private PostService service;

    public PostDeleteCtrl() {
    }

    public PostDeleteCtrl(PostService service) {
        this.service = service;
    }

    public int delete(int id) {

        List<PostResponseDTO> list = service.selectService();
        list.removeIf(post -> post.getId() == id);
        return 1;
    }

}
