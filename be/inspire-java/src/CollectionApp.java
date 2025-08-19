import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;

public class CollectionApp {
    /*
    Collection API
    - List(중복허용, 순서존재, 객체를 요소로 갖는다, 가변길이)
    - Set(중복 X, 순서 X, 객체를 요소로 갖는다, 가변길이) 

    - Map({ key : value} )

    Wrapper Class( Boxing , UnBoxing ) 
    - int -> Integer , char -> Character
    */
    public static void main(String[] args) {
        System.out.println(">>>> Array "); 
        int [] ary = new int[5] ; 
        ary[0] = 10; ary[1] = 20; ary[2] = 30; ary[3] = 40; ary[4] = 50;
        // ary[5] = 60;
        System.out.println(">>>> length : "+ary.length); 
        ary[2] = 0 ;
        System.out.println( Arrays.toString(ary) ); 

        System.out.println();
        System.out.println(">>>> List"); 

        // add() , get(), remove(), size()
        List<Integer> list = new ArrayList<Integer>() ;
        list.add(10);
        list.add(20);
        list.add(10); 
        System.out.println( list.toString() );   
        for(int idx=0 ; idx < list.size() ; idx++) {
            Integer data = list.get(idx);
            System.out.println(data);
        }

        //////////////////////////////////////////////////////
        
        List<PersonDTO> perList = new ArrayList<PersonDTO>() ;
        TeacherDTO tea = TeacherDTO.builder()
                            .name("임정섭")
                            .age(20)
                            .address("서울")
                            .subject("자바")
                            .build() ; 
        
        
        StudentDTO stu = StudentDTO.builder()
                            .name("이현진")
                            .age(24)
                            .address("서울")
                            .stuId("2005") 
                            .build() ;
        perList.add(tea); 
        perList.add(stu);
        for(int idx=0 ; idx < perList.size() ; idx++) {
            System.out.println( perList.get(idx).perInfo() );
        }

        System.out.println();
        System.out.println(">>>> Set");
        Set<String> set = new HashSet<>();
        set.add("jslim"); set.add("inspire"); set.add("lgcns");
        set.add("jslim");
        System.out.println( set ); 

        Object [] setAry = set.toArray() ;
        for( Object value : setAry) {
            System.out.println( value ); 
        }

        System.out.println();
        System.out.println(">>>> Map"); 

        Map<String, List<? extends PersonDTO>> map = new HashMap<>();

        List<StudentDTO> stuList = new ArrayList<>() ;
        stuList.add(stu);
        
        List<TeacherDTO> teaList = new ArrayList<>() ;
        teaList.add(tea);

        map.put("stu" , stuList);
        map.put("tea" , teaList);
        
        List<? extends PersonDTO> perStuList = map.get("stu");
        for(PersonDTO per : perStuList) {
            System.out.println( per.perInfo() ); 
        }
        List<? extends PersonDTO> perTeaList = map.get("tea");
        for(PersonDTO per : perTeaList) {
            System.out.println( per.perInfo() ); 
        }
    }
}
