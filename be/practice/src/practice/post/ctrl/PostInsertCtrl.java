package practice.post.ctrl;

import java.util.List;

import practice.post.domain.dto.PostRequestDTO;
import practice.post.domain.dto.PostResponseDTO;
import practice.post.service.PostService;

public class PostInsertCtrl {

    private PostService service;

    public PostInsertCtrl() {
    }

    public PostInsertCtrl(PostService service) {
        this.service = service;
    }

    public int insert(String title, String content, String writer) {
        System.out.println(">>>post insert ctrl");
        List<PostResponseDTO> list = service.selectService();

        PostRequestDTO request = PostRequestDTO.builder()
                .id(list.size() + 1)
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        return service.insertService(request);
    }

}
