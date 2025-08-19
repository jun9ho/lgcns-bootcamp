import java.beans.beancontext.BeanContext;

import lgcns.inspire.abstraction.LgTV;
import lgcns.inspire.abstraction.SamsungTV;
import lgcns.inspire.abstraction.inter.TV;
import lgcns.inspire.factory.BeanFactory;

public class TvApp {

    public static void main(String[] args) {
        // SamsungTV tv = new SamsungTV();
        // tv.turnOn();
        
        // LgTV tv = new LgTV() ; 
        // tv.powerOn(); 

        // TV tv = new SamsungTV() ; 
        // tv.powerOn();
        // SamsungTV s01 = new SamsungTV() ; 
        // SamsungTV s02 = new SamsungTV() ;
        // System.out.println(s01+"\t"+s02); 
        
        // BeanFactory factory01 = BeanFactory.getInstance();
        // BeanFactory factory02 = BeanFactory.getInstance();
        
        // System.out.println(factory01);
        // System.out.println(factory02);
        
        BeanFactory factory = BeanFactory.getInstance();
        TV tv = factory.getBrand("samsung");
        tv.powerOn();

    }
    
}
