package com.lgcns.inspire_restspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lgcns.inspire_restspring.rest.blog.domain.BlogRequestDTO;
import com.lgcns.inspire_restspring.rest.blog.domain.BlogResponseDTO;
import com.lgcns.inspire_restspring.rest.blog.repository.BlogMapper;

@SpringBootTest
public class BlogTddTests {
    //TDD - Red (failng test) : (블로그 등록 기능)
    //main에 모든걸 가져다가 쓸 수 있따.

    @Autowired
    private BlogMapper mapper;  

    // @BeforeEach
    // public void init(){
    //     //given data 삽입
    // }

    @Test
    public void blogInsertTest(){
        //given
        BlogRequestDTO request = new BlogRequestDTO();
        request.setTitle("불금");
        request.setContent("이얏호");

        //when
        int flag = mapper.insertRow(request);

        //then
        assertEquals(1,flag);
        assertNotNull(request.getId());
        System.out.println(">>>flag: "+flag);

    }

    @Test
    public void blogUpdateTest(){
        //given
        BlogRequestDTO request = new BlogRequestDTO();
        request.setTitle("TDD");
        request.setContent("Junit 단위 테스트");
        request.setId(4);
        //when

        int flag = mapper.updateRow(request);
        System.out.println(">>>flag: "+flag);

        //then(검증 포인트)
        assertEquals(1, flag);
        
        BlogResponseDTO response = mapper.findById(request.getId());
        assertEquals(request.getTitle(), response.getTitle());
        assertEquals(request.getContent(), response.getContent());


    }

    @Test
    public void blogListTest(){
        //given

        //when
        List<BlogResponseDTO> list = mapper.selectRow();

        //then
        //검증 포인트: 조회결과 null 아니어야함, 리스트 데이터 존재 여부
        //stream: 필터링을 통한 검증
        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertTrue(list.size()>=3);

        //무결성
        assertTrue(list.stream().allMatch(blog->blog.getTitle()!=null));

    }

    @Test
    public void blogDeleteTest(){
        //given
        BlogRequestDTO blog = new BlogRequestDTO();
        blog.setId(4);

        //when
        int beforeCnt =mapper.selectRow().size();
        int flag = mapper.deleteRow(blog);
        int afterCnt = mapper.selectRow().size();

        //then
        assertEquals(1, flag);
        assertNull(mapper.findById(4));
        assertEquals(beforeCnt-1, afterCnt);
    }

    @Test
    public void blogFindKeyword(){
        //given
        String keyword = "불금";
        
        //when
        List<BlogResponseDTO> list = mapper.findByKeyword(keyword);


        //then
        assertNotNull(list);
        assertFalse(list.isEmpty());

        list.stream().forEach(System.out::println);
    }

}
