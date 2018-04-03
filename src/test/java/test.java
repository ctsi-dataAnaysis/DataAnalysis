<<<<<<< HEAD
import java.util.Locale;
=======
import javax.servlet.Servlet;
import java.util.Locale;
import java.util.Queue;
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949

/**
 * Created by Zhao Qing on 2017/11/17.
 */
public class test {
    public static void main(String[] args){
<<<<<<< HEAD
=======

>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
        String s1 = new String("java");//创建了一个String引用，指向“java”
        String s2 = new String("java");//又创建了一个String引用，同样指向“java”
        //引用s1与引用s2指向的对象是一样的，但是它们两本身不同

        boolean flag = (s1 == s2);

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.hasCode: " + s1.hashCode());
        System.out.println("s2.hasCode: " + s2.hashCode());

        System.out.println(Locale.getDefault());
    }
}
