package com.lgcns.practice_inspire_spring.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgcns.practice_inspire_spring.comment.domain.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer>{
    
}
