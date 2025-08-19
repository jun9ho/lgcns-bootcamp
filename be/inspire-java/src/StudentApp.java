import lgcns.Student;

public class StudentApp {

    public static void main(String[] args) {
        
        Student instance = new Student();
        System.out.println("[deubg] >>>> "+instance);
        System.out.println("[deubg] >>>> "+instance.name);
        System.out.println("[deubg] >>>> "+instance.gender);
                
        instance.name="이현진";
        instance.gender='M' ;

        System.out.println("[deubg] >>>> "+instance.name);
        System.out.println("[deubg] >>>> "+instance.gender);
        
        instance.stuInfo(); 

    }
}

