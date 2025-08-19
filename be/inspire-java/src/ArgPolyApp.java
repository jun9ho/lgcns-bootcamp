

import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;

public class ArgPolyApp {

    private static PersonDTO [] perAry = new PersonDTO[10];
    private static int idx = 0 ;  
    
    public static void main(String[] args) {
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
        
        setPerAry(stu);
        setPerAry(tea);

        printAry();
    }

    public static void setPerAry(PersonDTO element) {
        perAry[idx++] = element ; 
    }


    public static void printAry() {
        System.out.println(">>>>>> 전체 출력 ");
        System.out.println();
        for(PersonDTO element : perAry) {
            if( element != null) {
                System.out.println( element.perInfo() ); 
            } else {
                break ;
            }    
        }
    }
}

