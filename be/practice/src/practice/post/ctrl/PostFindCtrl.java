package practice.post.ctrl;

import java.util.Optional;

import practice.post.domain.dto.PostResponseDTO;
import practice.post.service.PostService;

public class PostFindCtrl {

    private PostService service;

    public PostFindCtrl() {
    }

    public PostFindCtrl(PostService service) {
        this.service = service;
    }

    public  Optional<PostResponseDTO> findPost(int id){

        System.out.println(">>>post find ctrl");
        return service.selectService(id);
    }
}
