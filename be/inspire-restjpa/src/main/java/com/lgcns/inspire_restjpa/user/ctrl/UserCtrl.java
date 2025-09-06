package com.lgcns.inspire_restjpa.user.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restjpa.user.domain.dto.UserRequestDTO;
import com.lgcns.inspire_restjpa.user.domain.dto.UserResponseDTO;
import com.lgcns.inspire_restjpa.user.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v2/inspire/user")
public class UserCtrl {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody  @Valid UserRequestDTO request, BindingResult bindingResult) {
        System.out.println(">>> user ctrl Post /signup ");
        System.out.println(">>> user ctrl Post /signup param " + request);
        UserResponseDTO response = userService.signup(request);


        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getAllErrors().forEach(err->{
                FieldError filed = (FieldError) err;
                String msg = err.getDefaultMessage();
                System.out.println(">>> validation err : "+ filed.getField()+" - "+ msg);
                errorMap.put(filed.getField(),msg);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
        }

        if(response !=null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //인증, 인가: cookie, session, jwt token

    //인증(Authentication) : 누구인지 확인하는 절차
    //Bearer token => JWT 기반 인증, OAuth2
    //toekn(accessToken, refreshToken)
    //응답시(body에 data를 심는게 아닌 header쪽에다가 token을 심는다)
    //Authorization: Bearer<token>

    //인가(Authorization) : 권한부여(endpoint 접근권한)
    //요청시(header 응답시 전송한 bearer token 유무를 체크하고 접근권한이 있는지 확인)

    //로그인하는 행위 -> 인증
    //인증된 사용자가 특정 엔드포인트에 접근가능 -> 인가
    //public ResponseEntity<UserResponseDTO> signin(@RequestParam @Valid UserRequestDTO request) { 
    @GetMapping("/signin")
    public ResponseEntity<UserResponseDTO> signin(UserRequestDTO request) {
        System.out.println(">>> user ctrl Post /signin ");
        System.out.println(">>> user ctrl Post /signin param " + request);
        UserResponseDTO response = userService.signin(request);
        return ResponseEntity.status(HttpStatus.OK)
                             .header("Authorization","Bearer"+response.getAccessToken())
                             .header("Refresh-Token",response.getRefreshToken())
                             .body(response); 
    }

}
