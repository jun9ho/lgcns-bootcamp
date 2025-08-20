package practice.post.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        System.out.println(">>>> post delete ctrl delete params : " + id);
        Map<String,Integer>map = new HashMap<>();
        map.put("key", id);

        return service.deleteService(map);
    }

}
