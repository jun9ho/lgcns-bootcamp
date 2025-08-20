package practice.post.factory;

import java.util.HashMap;
import java.util.Map;

import practice.post.ctrl.PostSaveCtrl;
import practice.post.ctrl.PostDeleteCtrl;
import practice.post.ctrl.PostFindCtrl;
import practice.post.ctrl.PostInsertCtrl;
import practice.post.ctrl.PostListCtrl;
import practice.post.ctrl.PostSearchCtrl;
import practice.post.ctrl.PostUpdateCtrl;
import practice.post.service.PostService;
import practice.post.service.PostServiceImpl;

/*
Singleton Pattern 
- 인스턴스를 하나로 유지하는 방법 (무분별한 객체생성을 방지) : Inversion Of Control(IOC) 
- 문법)
    - 생성자의 접근제어자를 private
    - 자신의 타입을 반환하는 메서드를 static 

*/
public class BeanFactory {

    private static BeanFactory instance;
    private Map<String, Object> map;
    private PostService service;

    private BeanFactory() {
        service = new PostServiceImpl();
        map = new HashMap<>();
        map.put("list", new PostListCtrl(service));
        map.put("find", new PostFindCtrl(service));
        map.put("insert", new PostInsertCtrl(service));
        map.put("delete", new PostDeleteCtrl(service));
        map.put("update", new PostUpdateCtrl(service));
        map.put("search", new PostSearchCtrl(service));
        map.put("save", new PostSaveCtrl(service));
    }

    public static BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }

    public Object getCtrl(String requestURL) {
        return map.get(requestURL);
    }

}
