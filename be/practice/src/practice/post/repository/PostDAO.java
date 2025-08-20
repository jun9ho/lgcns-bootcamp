package practice.post.repository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import practice.post.domain.dto.PostRequestDTO;
import practice.post.domain.dto.PostResponseDTO;

public class PostDAO {

    private List<PostResponseDTO> posts;

    public PostDAO() {

        // 초기 데이터 생성
        // posts = new ArrayList<>(Arrays.asList(
        //         PostResponseDTO.builder()
        //                 .id(1)
        //                 .title("mvc")
        //                 .content("springboot")
        //                 .writer("jslim").build(),
        //         PostResponseDTO.builder()
        //                 .id(2)
        //                 .title("stream api")
        //                 .content("기초문법")
        //                 .writer("jslim").build(),
        //         PostResponseDTO.builder()
        //                 .id(3)
        //                 .title("lambda")
        //                 .content("함수형 인터페이스와 연동")
        //                 .writer("lgcns").build(),
        //         PostResponseDTO.builder()
        //                 .id(4)
        //                 .title("springboot")
        //                 .content("pattern 조합")
        //                 .writer("inspire").build()));
        posts = new ArrayList<PostResponseDTO>();

        // 파일 입력 
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\jungh\\Desktop\\Project\\inspire\\be\\practice\\test.txt"))) {
            posts.clear();
            posts = (List<PostResponseDTO>)ois.readObject() ; 
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //C(입력)
    public int insertRow(PostRequestDTO post)
    {
        System.out.println("PostDAO.insertRow()");
        int flag = 1;
        posts.add(PostRequestDTO.toResponseDTO(post));
        return flag;
    }

    //R(전체 검색)
    public List<PostResponseDTO> selectRow() {
        System.out.println(">>>> dao selectRow");
        // 데이터베이스 연동 후 값을 가져온다고 가정하고 더미데이터를 생성
        return posts ; 
    }

    // U(수정)
    public int updateRow(PostRequestDTO request) {

        //구현
        System.out.println(">>>> dao updateRow");

        boolean flag = posts.stream()
                .filter(post -> post.getId() == request.getId())
                .peek(post -> {
                    post.setTitle(request.getTitle());
                    post.setContent(request.getContent());
                })
                .count() > 0;

        return flag ? 1 : 0;
    }

    // D(삭제) 
    public int deleteRow(Map<String, Integer> map) {

        System.out.println(">>>> dao deleteRow id");

        //(SQL)
        
        //1,  removeIf 2. stream -> filter
        boolean flag = posts.removeIf(post -> post.getId() == map.get("key"));
        return flag ? 1 : 0;
    }


}
