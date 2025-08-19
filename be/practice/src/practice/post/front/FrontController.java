package practice.post.front;

import java.util.List;
import java.util.Optional;

import practice.post.ctrl.PostDeleteCtrl;
import practice.post.ctrl.PostFindCtrl;
import practice.post.ctrl.PostInsertCtrl;
import practice.post.ctrl.PostListCtrl;
import practice.post.ctrl.PostSearchCtrl;
import practice.post.ctrl.PostUpdateCtrl;
import practice.post.domain.dto.PostResponseDTO;
import practice.post.factory.BeanFactory;

public class FrontController {

    private BeanFactory factory;

    public FrontController() {
        factory = BeanFactory.getInstance();
    }

    public List<PostResponseDTO> list(String requestURL) {
        System.out.println(">>>> front ctrl list");

        PostListCtrl obj = (PostListCtrl) factory.getCtrl(requestURL);
        return obj.list();

    }

    public Optional<PostResponseDTO> findPost(String requestURL, int id) {
        System.out.println(">>>> front ctrl findPost params : " + id);

        PostFindCtrl obj = (PostFindCtrl) factory.getCtrl(requestURL);
        return obj.findPost(id);
    }

    public int insert(String requestURL, String title, String content, String writer) {
        System.out.println(">>>> front ctrl insert params : " + title);
        System.out.println(">>>> front ctrl insert params : " + content);
        System.out.println(">>>> front ctrl insert params : " + writer);

        PostInsertCtrl obj = (PostInsertCtrl) factory.getCtrl(requestURL);
        return obj.insert(title, content, writer);
    }

    public int delete(String requestURL, int id) {
        System.out.println(">>>> front ctrl delete params id : " + id);

        PostDeleteCtrl obj = (PostDeleteCtrl) factory.getCtrl(requestURL);
        return obj.delete(id);
    }

    public int update(String requestURL, String title, String content, int id) {
        System.out.println(">>>> front ctrl update params : " + title);
        System.out.println(">>>> front ctrl update params : " + content);
        System.out.println(">>>> front ctrl update params : " + id);

        PostUpdateCtrl obj = (PostUpdateCtrl) factory.getCtrl(requestURL);
        return obj.update(title, content, id);
    }

    public Optional<List<PostResponseDTO>> search(String requestURL, String writer) {
        System.out.println(">>>> front ctrl search params : " + writer);

        PostSearchCtrl obj = (PostSearchCtrl) factory.getCtrl(requestURL);
        return obj.search(writer);
    }
}
