package com.lgcns.practice_inspire_spring.user.ctrl;

import java.lang.module.ResolutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.practice_inspire_spring.user.domain.dto.UserRequestDTO;
import com.lgcns.practice_inspire_spring.user.domain.dto.UserResponseDTO;
import com.lgcns.practice_inspire_spring.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v10/inspire/user")
@Tag(name = "User API", description = "유저 관련 API 명세서")
public class UserCtrl {

    @Autowired
    UserService userService;

    // 회원가입 , 데이터 생성, request body에 json이옴
    @PostMapping("/signup")
    @Operation(summary = "유저 회원가입",
               description = "이메일, 패스워드, 이름을 받아서 데이터베이스에 등록합니다.")
    public ResponseEntity signup(@io.swagger.v3.oas.annotations.parameters.RequestBody(description="생성할 유저를 전달받음")
                                 @RequestBody UserRequestDTO request) {
        System.out.println(">>> user ctrl Post /signup ");
        System.out.println(">>> user ctrl Post /signup param " + request);
        userService.signup(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/signin")
    @Operation(summary="유저 로그인",
               description = "이메일, 패스워드를 받아서 로그인합니다. ")
    public ResponseEntity<UserResponseDTO> signin(@io.swagger.v3.oas.annotations.parameters.RequestBody(description="로그인에 필요한 자격 증명(email, password)을 전달받음")
                                                  @RequestBody UserRequestDTO request) {
        System.out.println(">>> user ctrl Post /signin ");
        System.out.println(">>> user ctrl Post /signin param " + request);
        UserResponseDTO response = userService.signin(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

}
