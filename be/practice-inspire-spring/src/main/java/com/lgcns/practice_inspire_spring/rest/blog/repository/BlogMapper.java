package com.lgcns.practice_inspire_spring.rest.blog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lgcns.practice_inspire_spring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.practice_inspire_spring.rest.blog.domain.BlogResponseDTO;

@Mapper
public interface BlogMapper {
    public List<BlogRequestDTO> selectRow();

    public int insertRow(BlogRequestDTO request);

    public int updateRow(BlogRequestDTO request);

    public int deleteRow(BlogRequestDTO request);

    public BlogResponseDTO findById(Integer id);

    public List<BlogResponseDTO> findByKeyword(String keyword);
}
