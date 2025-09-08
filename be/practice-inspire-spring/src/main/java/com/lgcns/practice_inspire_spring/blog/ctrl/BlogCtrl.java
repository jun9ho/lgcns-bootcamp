package com.lgcns.practice_inspire_spring.blog.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.practice_inspire_spring.blog.domain.dto.BlogRequestDTO;
import com.lgcns.practice_inspire_spring.blog.domain.dto.BlogResponseDTO;
import com.lgcns.practice_inspire_spring.blog.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v10/blog")
public class BlogCtrl {

    @Autowired
    private BlogService service;

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDTO>> blogs() {

        List<BlogResponseDTO> list = service.select();
        return new ResponseEntity<List<BlogResponseDTO>>(list, HttpStatus.OK);
    }

    @Operation(summary = "블로그 입력", description = "타이틀과 컨텐츠를 받아서 데이트베이스에 등록합니다.")
    // http:serverip.port/api/v10/blog/register
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "생성할 블로그를 전달받음") @RequestBody BlogRequestDTO request) {
        System.out.println("[debug] >>> blog ctrl path : /register");
        System.out.println("[debug] param dto =" + request);

        int result = service.insert(request);
        if (result != 0) {
            // return new ResponseEntity<>(HttpStatus.CREATED);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/read/{id}")
    public ResponseEntity<BlogResponseDTO> read(@PathVariable("id") Integer id) {
        BlogResponseDTO response = service.find(id);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK); // 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
    }

    @PutMapping("update/{id}/")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody BlogRequestDTO request) {
        int result = service.update(id, request);
        if (result != 0) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        int result = service.delete(id);
        if (result != 0) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/search/")
    public ResponseEntity<List<BlogResponseDTO>> search(@RequestParam("keyword") String keyword) {
        List<BlogResponseDTO> list  = service.findKeyword(keyword);
         return new ResponseEntity<List<BlogResponseDTO>>(list,HttpStatus.OK);
    }

}
