package lgcns.inspire.post.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;

public interface PostService {
    public List<PostResponseDTO>        selectService() ;
    public Optional<PostResponseDTO>    selectSerivce(int id) ; 
    public int                          insertService(PostRequestDTO request); 
    
    //////////////////
    // public List<PostResponseDTO>        searchService(String writer) ;
    public Optional<List<PostResponseDTO>> searchService(String writer) ;
    
    // delete
    public int                          deleteService(Map<String, Integer> map);

    // update
    public int                          updateService(PostRequestDTO request); 

    // file save or load 
    public List<PostResponseDTO>        loadToFile() ; 
    public boolean                      saveToFile() ;   
    

}

