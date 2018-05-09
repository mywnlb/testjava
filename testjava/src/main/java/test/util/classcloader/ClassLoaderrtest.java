package test.util.classcloader;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by lb on 2018/5/8.
 */
public class ClassLoaderrtest {
    public static void main(String[] args) throws IOException {
        ClassLoader systemloader = ClassLoader.getSystemClassLoader();
        System.out.println("----------------------");
        Enumeration<URL> eml = systemloader.getResources("");
        while(eml.hasMoreElements()){
            System.out.println(eml.nextElement());
        }
        ClassLoader extensionLader = systemloader.getParent();
        System.out.println(extensionLader+"------------");
        System.out.println(extensionLader.getParent()+"+++++++++++++++++++++++++++++");

    }


    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader mcl = new MyClassLoader();
        Class<?> clazz = Class.forName("test", true, mcl);
        Object obj = clazz.newInstance();

        Class<?> clazz1 = Class.forName("test.util.classcloader.ClassLoadertest", true, ClassLoader.getSystemClassLoader());
        Object obj1 = clazz1.newInstance();

        System.out.println(obj.getClass().getClassLoader());//打印出我们的自定义类加载器
        System.out.println(obj1.getClass().getClassLoader());//打印出我们的自定义类加载器

    }

    @Test
    public void testresource(){
        String bootClassPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootClassPath);
    }
}
