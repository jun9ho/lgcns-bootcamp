package com.lgcns.practice_inspire_spring.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgcns.practice_inspire_spring.blog.domain.entity.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Integer>{
    
    public List<BlogEntity> findByContentContaining(String content);
}
