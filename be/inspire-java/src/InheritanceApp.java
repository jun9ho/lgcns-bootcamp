import lgcns.Student;
import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;

public class InheritanceApp {

    public static void main(String[] args) {
        
        // 강사객체를 생성하고 싶다면?
        // PersonDTO tea = PersonDTO.builder()
        //                     .name("임섭순")
        //                     .age(20)
        //                     .address("서울")
        //                     .subject("자바")
        //                     .build() ;
        // System.out.println(">>>> tea : " + tea);

        // PersonDTO stu = PersonDTO.builder()
        //                     .name("이현진")
        //                     .age(24)
        //                     .address("서울")
        //                     .stuId("2025")
        //                     .build();
        // System.out.println(">>>> stu : " + stu); 
        
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

        // TeacherDTO [] teaAry = new TeacherDTO[10];
        // teaAry[0] = tea;
        
        // StudentDTO [] stuAry = new StudentDTO[10];
        // stuAry[0] = stu; 

        // 다형성(polymorphism)     
        // PersonDTO tea = new TeacherDTO() ;
        // PersonDTO stu = new StudentDTO() ;

        PersonDTO [] perAry = new PersonDTO[10] ; 
        perAry[0] = tea ; 
        perAry[1] = stu ; 
        
        // ? 
        // instanceof 연산자 : 런타입 시점에 타입체크해주는 논리연산자 
        for(int idx = 0 ; idx < perAry.length ; idx++) {
            
            // System.out.println(perAry[idx].getClass());
            
            PersonDTO per = perAry[idx] ; 
            // if( per == null) {
            //     break;
            // } else if( per instanceof StudentDTO) {
            //     System.out.println(((StudentDTO)per).stuInfo() );
            // } else if( per instanceof TeacherDTO) {
            //     System.out.println(((TeacherDTO)per).teaInfo() );
            // }
            if( per == null) {
                break;
            } else {
                System.out.println( per.perInfo() ); 
            }        
        }
    } // main end 
}
