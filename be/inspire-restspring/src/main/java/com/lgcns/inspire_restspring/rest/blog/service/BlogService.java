package com.lgcns.inspire_restspring.rest.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.repository.BlogMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    
    private final BlogMapper mapper;

    public List<BlogResponseDTO> select(){
        System.out.println("[debug] >>> blog service select ");
        return mapper.selectRow();   
    }

    public int insert(BlogRequestDTO request){
        System.out.println("[debug] >>> blog service insert ");
        return mapper.insertRow(request);   
    }
    
    public BlogResponseDTO find(Integer id){
        System.out.println("[debug] >>> blog service find ");
        return mapper.findById(id);
    }

    public int update(Integer id, BlogRequestDTO request){
        System.out.println("[debug] >>> blog service update ");
        mapper.findById(id);
        request.setId(id);
        return mapper.updateRow(request);// ORM은 객체 하나만 받기때문에
    }

    public int delete(Integer id){
        System.out.println("[debug] >>> blog service delete ");
        BlogRequestDTO request = new BlogRequestDTO();
        request.setId(id);
        return mapper.deleteRow(request);// ORM은 객체 하나만 받기때문에
    }

    public List<BlogResponseDTO> findKeyword(String keyword){
        System.out.println("[debug] >>> blog service findKeyword ");
        return mapper.findByKeyword(keyword);// ORM은 객체 하나만 받기때문에
    }
}
