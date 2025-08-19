package practice.post.service;

import java.util.List;
import java.util.Optional;

import practice.post.domain.dto.PostRequestDTO;
import practice.post.domain.dto.PostResponseDTO;
import practice.post.repository.PostDAO;

public class PostServiceImpl implements PostService {

    private PostDAO dao;

    public PostServiceImpl() {
        dao = new PostDAO();
    }

    @Override
    public List<PostResponseDTO> selectService() {
        return dao.selectRow();
    }

    @Override
    public Optional<PostResponseDTO> selectService(int id) {
        System.out.println(">>>> post service selectService : params id ");
        List<PostResponseDTO> list = dao.selectRow();
        Optional<PostResponseDTO> result = list.stream().filter(post -> post.getId() == id).findAny();
        return result;
    }

    @Override
    public int insertService(PostRequestDTO request) {
        System.out.println(">>>> post service insertService : params request " + request);
        return dao.insertRow(request);
    }

        // @Override
    // public List<PostResponseDTO> searchService(String writer) {
    //     System.out.println(">>>> post service searchService : params writer "+writer);
    //     List<PostResponseDTO> list = dao.selectRow() ;
    //     // db : groupBy(), partitioningBy()
    //     return list.stream()
    //                 .filter(post -> post.getWriter().equals(writer))
    //                 .collect(Collectors.toList()) ; 
    // }

    
    @Override
    public Optional<List<PostResponseDTO>> searchService(String writer) {
        System.out.println(">>>> post service searchService : params writer " + writer);
        List<PostResponseDTO> list = dao.selectRow();

        List<PostResponseDTO> result = list.stream().filter(post -> post.getWriter().equals(writer)).toList();
        return Optional.ofNullable(result);
    }

}
