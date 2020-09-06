package test;

import java.util.*;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description:
 * @date 2020/7/13 9:27
 */
public class Test {
    public static void main(String[] args) {
        //1-33 6个
        //1-16 1个
        Integer num6 = 1;
        List<Integer> list33 = new ArrayList<>();
        List<Integer> list16 = new ArrayList<>();
        List<Integer> list6 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> suiJ = new ArrayList<>();
        for(int i=1;i<=33;i++){
            list33.add(i);
        }
        for(int i=1;i<=16;i++){
            list16.add(i);
        }
        //生成随机数
        Random random = new Random();
        while (num6<=6){
            int i = random.nextInt(list33.size());
            list6.add(list33.get(i));
            list33.remove(i);
            num6++;
        }
        int i = random.nextInt(list16.size());
        list1.add(list16.get(i));
        list16.remove(i);
        list6.sort(Comparator.comparing(Integer::intValue));//升序
        System.out.println(list6);
        System.out.println(list1);
        switch (num6){
            case 7:
                System.out.println("HHHHHH");
                break;
            default:
                System.out.println("meiyou");
                break;
        }
    }


}
