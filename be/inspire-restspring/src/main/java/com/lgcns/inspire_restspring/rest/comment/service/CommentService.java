package com.lgcns.inspire_restspring.rest.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.repository.BlogMapper;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentResponseDTO;
import com.lgcns.inspire_restspring.rest.comment.repository.CommentMapper;

import jakarta.transaction.Transactional;

@Service
public class CommentService {
    
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BlogMapper blogMapper;

    // 데이터베이스 작업의 논리적 단위로 작업을 하나로 묶어서
    // 전부 성공(commit) 또는 전부 실패(rollback)
    // 일부 commit, 일부 rollback X
    @Transactional
    public List<CommentResponseDTO> insertComment(CommentRequestDTO request){
        System.out.println("[debug] >>> comment service insert comment ");
        List<CommentResponseDTO> list =null;
        BlogResponseDTO blog = 
            blogMapper.findById(request.getBlog_id());
        
        if(blog!=null){
            int flag = commentMapper.insertRow(request);
            if(flag==1){
                list = commentMapper.selectRow(request.getBlog_id());
                return list;
            }
        }   
        else{
            throw new RuntimeException("Blog not found!");
        } 

        return list;
    }

    public int deleteComment(Integer id)
    {
        System.out.println("[debug] >>> comment service delete comment ");
        return commentMapper.deleteRow(id);
    }
}
