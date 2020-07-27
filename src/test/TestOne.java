package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/14 18:30
 */
public class TestOne {
    public static void main(String[] args) {
        /*new Vector<>();
        new LinkedList<>();*/
        /*A ab = new B();//a1a2b1b212
        System.out.println(ab.hashCode());
        ab = new B();//12
        System.out.println(ab.hashCode());
        ab = new A();//1
        System.out.println(ab.hashCode());*/
        /*A ab = new B();//12AB
        ab = new B();//ab*/
        int oldCapacity = 20;
        System.out.println(oldCapacity + (oldCapacity >> 1));//1.5

        //Collections.synchronizedCollection(new ArrayList<>());
    }
}
