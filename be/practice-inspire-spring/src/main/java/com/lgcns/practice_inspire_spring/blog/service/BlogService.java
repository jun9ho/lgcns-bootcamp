package com.lgcns.practice_inspire_spring.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lgcns.practice_inspire_spring.blog.domain.dto.BlogRequestDTO;
import com.lgcns.practice_inspire_spring.blog.domain.dto.BlogResponseDTO;
import com.lgcns.practice_inspire_spring.blog.domain.entity.BlogEntity;
import com.lgcns.practice_inspire_spring.blog.repository.BlogRepository;
import com.lgcns.practice_inspire_spring.user.domain.dto.UserResponseDTO;
import com.lgcns.practice_inspire_spring.user.domain.entity.UserEntity;
import com.lgcns.practice_inspire_spring.user.repository.UserRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;

    // select , insert, find, update, delete, findKeyword

    public List<BlogResponseDTO> select() {

        List<BlogEntity> entity = blogRepository.findAll();
        List<BlogResponseDTO> list = new ArrayList<>();
        for (BlogEntity blogEnity : entity) {
            list.add(BlogResponseDTO.fromEntity(blogEnity));
        }

        return list;
    }

    public int insert(BlogRequestDTO request) {
        UserEntity author = userRepository.findById(request.getAuthorEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        BlogEntity saved = blogRepository.save(request.toEntity(author));
        return 1;
    }

    public BlogResponseDTO find(Integer id) {
        BlogEntity blogEntity = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 블로그입니다."));
        BlogResponseDTO blog = BlogResponseDTO.fromEntity(blogEntity);
        return blog;
    }

    @Transactional
    public int update(Integer id, BlogRequestDTO blog) {
        BlogEntity blogEntity = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 블로그입니다."));
        blogEntity.setTitle(blog.getTitle());
        blogEntity.setContent(blog.getContent());
        return 1;
    }

    public int delete(Integer id){
        blogRepository.deleteById(id);
        return 1;
    }

    public List<BlogResponseDTO> findKeyword(String keyword){
        List<BlogEntity> entity = blogRepository.findByContentContaining(keyword);
        List<BlogResponseDTO> list = new ArrayList<>();
        for (BlogEntity blogEnity : entity) {
            list.add(BlogResponseDTO.fromEntity(blogEnity));
        }
        return list;
    }
    
}
