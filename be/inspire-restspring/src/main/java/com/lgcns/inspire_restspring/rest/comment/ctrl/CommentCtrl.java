package com.lgcns.inspire_restspring.rest.comment.ctrl;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.domain.CommentRequestDTO;
import com.lgcns.inspire_restspring.rest.comment.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/v1/blog/comment")
@Tag(name = "Blog Comment API",description = "블로그 댓글 관련 API 명세서")
public class CommentCtrl {
    

    //@Resource(name = "cs_ver")
    @Autowired
    private CommentService service;

    @Operation(
        summary = "블로그 댓글 입력",
        description = "blog_id, comment를 받아서 데이트베이스에 등록합니다."
    )
    // http:serverip.port/api/v1/blog/register
    @PostMapping("/register")
    public ResponseEntity<Void> register(
                            @RequestBody(description = "생성할 블로그 댓글 정보를 전달받음")
                            @org.springframework.web.bind.annotation.RequestBody CommentRequestDTO request) {
        System.out.println("[debug] >>> commen ctrl path : /register");
        System.out.println("[debug] param dto ="+request);
        
        int result = service.insertComment(request);
        if(result!=0){
            //return new ResponseEntity<>(HttpStatus.CREATED);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
