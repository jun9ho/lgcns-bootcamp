package com.lgcns.inspire_restspring.rest.blog.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


/*
 HTTP 통신 clinet가 웹서버에게(WAS-tomcat) 요청의 목적을 알리는 수단
 - Get(읽기), Post(새로운자원생성), Put, Patch, Delete(자원을 삭제)\

 요청 - 응답 템플릿 제공
 -RequestEntity, ResponseEntity
 */

@RestController
// http:serverip.port/api/v1/blog
@RequestMapping("/api/v1/blog")
@Tag(name="Blog API", description = "블로그 관련 API 명세서")
public class BlogCtrl {

    @Autowired
    private BlogService service;

    @Operation(
        summary = "블로그 전체 조회",
        description = "특정 블로그가 아닌 블로그 전체를 조회합니다."
    )
    @ApiResponses(
        {
            @ApiResponse(responseCode = "200",description = "전체조회 성공"),
            @ApiResponse(responseCode = "404",description = "전제초회 실패")
        }
    )
    // http:serverip.port/api/v1/blog/blogs
    @GetMapping("/blogs")
    //기본적으로 자바의 객체가 json형태가 된다 
    public ResponseEntity<List<BlogResponseDTO>> blogs(){
        System.out.println("[debug] >>> blog ctrl path : /blogs");
        // String response = "응답문자열";
        // Map<String, String> map = new HashMap<>();
        // map.put("id","jslim");
        // map.put("email","jsilm@naver.com");
        //return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
        List<BlogResponseDTO> list  = service.select();
        return new ResponseEntity<List<BlogResponseDTO>>(list,HttpStatus.OK);
        
    }

    // @Operation(
    //     summary = "블로그 입력",
    //     description = "타이틀과 컨텐츠를 받아서 데이트베이스에 등록합니다."
    // )
    // http:serverip.port/api/v1/blog/register
    // @PostMapping("/register")
    // public ResponseEntity<Void> register(
    //                         @Parameter(description = "title,content 입력")
    //                         @RequestParam("title") String title,
    //                         @RequestParam("content") String content) {
    //     System.out.println("[debug] >>> blog ctrl path : /register");
    //     System.out.println("[debug] param title ="+title);
    //     System.out.println("[debug] param content ="+content);
        
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    
    
    @Operation(
        summary = "블로그 입력",
        description = "타이틀과 컨텐츠를 받아서 데이트베이스에 등록합니다."
    )
    // http:serverip.port/api/v1/blog/register
    @PostMapping("/register")
    public ResponseEntity<Void> register(
                            @RequestBody(description = "생성할 블로그를 전달받음")
                            @org.springframework.web.bind.annotation.RequestBody BlogRequestDTO request) {
        System.out.println("[debug] >>> blog ctrl path : /register");
        System.out.println("[debug] param dto ="+request);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
        summary = "블로그 상세보기",
        description = "블로그 아이디로 특정 블로그를 조회합니다."
    )
    @GetMapping("/read/{id}")
    public ResponseEntity<BlogResponseDTO> read(
                        @Parameter(description = "조회할 블로그 ID")    
                        @PathVariable("id") Integer id) {
        System.out.println("[debug] >>> blog ctrl path GET : /read");
        System.out.println("[debug] param is ="+id);
        BlogResponseDTO response = BlogResponseDTO.builder().id(id).title("암암").content("흠흠흠").build();

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    @PutMapping("update/{id}/")
    public ResponseEntity<Void> putMethodName(
        @PathVariable("id") Integer id,
        @org.springframework.web.bind.annotation.RequestBody BlogRequestDTO request) {
        
        System.out.println("[debug] >>> blog ctrl path PUT : /update");
        System.out.println("[debug] param is ="+ id);
        System.out.println("[debug] param dto ="+ request);
        //return ResponseEntity.status(200) 도 가능
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        System.out.println("[debug] >>> blog ctrl path DELETE : /delete");
        System.out.println("[debug] param is ="+ id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
