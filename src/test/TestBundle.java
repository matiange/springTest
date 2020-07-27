package test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author MaTianGe
 * @version 0.1
 * @Description: 测试国际化
 * @date 2020/7/23 21:57
 */
public class TestBundle {
    public static void main(String[] args) {
        Locale zhLoc = new Locale("zh","CN");//表示中国地区:语言代码_国别代码
        Locale enLoc = new Locale("en","US");
        Locale frLoc = new Locale("fr","FR");
        ResourceBundle zhrb = ResourceBundle.getBundle("messages",zhLoc);//找到中文的属性文件（.getBundle(文件名称,区域码)）
        ResourceBundle enrb = ResourceBundle.getBundle("messages",enLoc);
        ResourceBundle frrb = ResourceBundle.getBundle("messages",frLoc);
        String str1 = zhrb.getString("110");
        String str2 = enrb.getString("110");
        System.out.println("中文："+ str1);//通过键值读取属性文件的类容MessageFormat.format(str1, "你好")
        System.out.println("英文："+ str2);//通过键值读取属性文件的类容MessageFormat.format(str1, "你好")

    }
}
