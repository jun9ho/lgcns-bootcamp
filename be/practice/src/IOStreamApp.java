import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import practice.post.domain.dto.PostResponseDTO;

public class IOStreamApp {

    public static void main(String[] args) {

        // File file = null;
        // FileWriter fw = null;
        // BufferedWriter bw = null;

        String data = "IO 파일 입출력";

        // 7 autoclose
        // try {} catch{} 를 쓰면 자동 close
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./test.txt")));) {
            bw.write(data);
            //bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<PostResponseDTO> posts = new ArrayList<>(Arrays.asList(
                PostResponseDTO.builder()
                        .id(1)
                        .title("mvc")
                        .content("springboot")
                        .writer("jslim").build(),
                PostResponseDTO.builder()
                        .id(2)
                        .title("stream api")
                        .content("기초문법")
                        .writer("jslim").build(),
                PostResponseDTO.builder()
                        .id(3)
                        .title("lambda")
                        .content("함수형 인터페이스와 연동")
                        .writer("lgcns").build(),
                PostResponseDTO.builder()
                        .id(4)
                        .title("springboot")
                        .content("pattern 조합")
                        .writer("inspire").build()));
        



    }
}
