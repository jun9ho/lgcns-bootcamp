package practice.post.service;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import practice.post.domain.dto.PostRequestDTO;
import practice.post.domain.dto.PostResponseDTO;
import practice.post.repository.PostDAO;

public class PostServiceImpl implements PostService {

    private PostDAO dao;

    public PostServiceImpl() {
        dao = new PostDAO();
    }

    @Override
    public List<PostResponseDTO> selectService() {
        return dao.selectRow();
    }

    @Override
    public Optional<PostResponseDTO> selectService(int id) {
        System.out.println(">>>> post service selectService : params id ");
        List<PostResponseDTO> list = dao.selectRow();
        Optional<PostResponseDTO> result = list.stream().filter(post -> post.getId() == id).findAny();
        return result;
    }

    @Override
    public int insertService(PostRequestDTO request) {
        System.out.println(">>>> post service insertService : params request " + request);
        return dao.insertRow(request);
    }

    // @Override
    // public List<PostResponseDTO> searchService(String writer) {
    // System.out.println(">>>> post service searchService : params writer
    // "+writer);
    // List<PostResponseDTO> list = dao.selectRow() ;
    // // db : groupBy(), partitioningBy()
    // return list.stream()
    // .filter(post -> post.getWriter().equals(writer))
    // .collect(Collectors.toList()) ;
    // }

    @Override
    public Optional<List<PostResponseDTO>> searchService(String writer) {
        System.out.println(">>>> post service searchService : params writer " + writer);
        List<PostResponseDTO> list = dao.selectRow();

        List<PostResponseDTO> result = list.stream().filter(post -> post.getWriter().equals(writer)).toList();
        return Optional.ofNullable(result);
    }

    @Override
    public int deleteService(Map<String, Integer> map) {
        System.out.println(">>>> post service deleteService : params map " + map);
        return dao.deleteRow(map);
    }

    @Override
    public int updateService(PostRequestDTO request) {
        System.out.println(">>>> post service updateService : params request " + request);
        return dao.updateRow(request);
    }

    @Override
    public List<PostResponseDTO> loadToFile() {
        System.out.println(">>>> post service loadToFile");
        return null;
    }

    @Override
    public boolean saveToFile() {
        System.out.println(">>>> post service saveToFile");
        boolean flag = false;
        List<PostResponseDTO> list = dao.selectRow();
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\jungh\\Desktop\\Project\\inspire\\be\\practice\\test.txt"))) {
            oos.writeObject(list);
            System.out.println(">>> 직렬화된 객체 파일에 저장 완료!!");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        return flag;

    }

}
