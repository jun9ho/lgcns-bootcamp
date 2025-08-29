package com.lgcns.inspire_restspring.rest.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

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
}
