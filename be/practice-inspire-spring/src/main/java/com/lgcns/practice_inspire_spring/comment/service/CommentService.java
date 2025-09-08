package com.lgcns.practice_inspire_spring.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.practice_inspire_spring.blog.repository.BlogRepository;
import com.lgcns.practice_inspire_spring.comment.repository.CommentRepository;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;

    //insertComment, deleteComment
}
