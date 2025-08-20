package practice.post.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import practice.post.domain.dto.PostRequestDTO;
import practice.post.domain.dto.PostResponseDTO;

public interface PostService {

    public List<PostResponseDTO> selectService();

    public Optional<PostResponseDTO> selectService(int id);

    public int insertService(PostRequestDTO request);

    public Optional<List<PostResponseDTO>> searchService(String writer);

    public int deleteService(Map<String,Integer> map);

    public int updateService(PostRequestDTO request);

    public List<PostResponseDTO> loadToFile();
    public boolean saveToFile();
}
