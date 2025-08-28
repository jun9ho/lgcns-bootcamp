package com.lgcns.inspire_spring.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgcns.inspire_spring.test.domain.TestRequestDTO;
import com.lgcns.inspire_spring.test.service.TestService;


// 객체 생성이 끝남
@Controller
@RequestMapping("/api/v1/test")
public class TestCtrl {

    // 기존 방식
    // TestService service = new TestService();

    @Autowired
    private TestService service;

    @GetMapping("/greeting")
    public void greeting() {
        System.out.println("[debug] >>> ctrl ");
        System.out.println("[debug] >>> service "+ service);

        TestRequestDTO request = TestRequestDTO.builder().emp_id("100").email("sg_ahn@vcc.com").build();
 

        System.out.println(service.testService(request));

    }

}
