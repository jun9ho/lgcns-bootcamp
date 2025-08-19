public class StringApp {

    public static void main(String[] args) {
        // String str01 = "inspire" , str02 = "inspire" ;
        String str01 = new String("jslim");
        String str02 = new String("jslim");
        if( str01 == str02) {
            System.out.println("str01 == str02");
        } else {
            System.out.println("str01 != str02");
        }
        if( str01.equals(str02)) {
            System.out.println("str01.equals(str02)");
        } else {
            System.out.println("!str01.equals(str02)");
        }

    }

}
