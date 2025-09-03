package com.lgcns.inspire_restspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lgcns.inspire_restspring.rest.comment.domain.CommentRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.service.CommentService;

@SpringBootTest
public class CommentTddTests {
    
    @Autowired
    private CommentService service;

    //@Test
    //public void commentCreateTest(){
    //    //given
    //    CommentRequestDTO request = CommentRequestDTO.builder()
    //                                    .blog_id(2)
    //                                    .comment("첫 번쨰 댓글")
    //                                    .build();
//
    //    //when
    //    int flag = service.insertComment(request);
//
    //    //then
    //    assertEquals(1, flag);
    //    assertNotNull(request.getId());
//
    //}
}
