package test.util.classcloader;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by lb on 2018/5/8.
 */
public class CompileClassLoader  extends ClassLoader
{

    // 读取一个文件的内容

    @SuppressWarnings("resource")
    private byte[] getBytes(String filename) throws IOException

    {

        File file = new File(filename);

        long len = file.length();

        byte[] raw = new byte[(int) len];

        FileInputStream fin = new FileInputStream(file);

        // 一次读取class文件的全部二进制数据

        int r = fin.read(raw);

        if (r != len){
            throw new IOException("无法读取全部文件" + r + "!=" + len);
        }

        fin.close();
        return raw;

    }

    // 定义编译指定java文件的方法

    private boolean compile(String javaFile) throws IOException

    {

        System.out.println("CompileClassLoader:正在编译" + javaFile + "……..");

        // 调用系统的javac命令

        Process p = Runtime.getRuntime().exec("javac" + javaFile);

        try {

            // 其它线程都等待这个线程完成

            p.waitFor();

        } catch (InterruptedException ie)

        {

            System.out.println(ie);

        }

        // 获取javac 的线程的退出值

        int ret = p.exitValue();

        // 返回编译是否成功

        return ret == 0;

    }

    // 重写Classloader的findCLass方法

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException

    {

        Class clazz = null;

        // 将包路径中的.替换成斜线/

        String fileStub = name.replace(".", "/");

        String javaFilename = fileStub + ".java";

        String classFilename = fileStub + ".class";

        File javaFile = new File(javaFilename);

        File classFile = new File(classFilename);

        // 当指定Java源文件存在，且class文件不存在，或者Java源文件的修改时间比class文件//修改时间晚时，重新编译

        if (javaFile.exists() && (!classFile.exists())
                || javaFile.lastModified() > classFile.lastModified())

        {

            try {

                // 如果编译失败，或该Class文件不存在

                if (!compile(javaFilename) || !classFile.exists())

                {

                    throw new ClassNotFoundException("ClassNotFoundException:"
                            + javaFilename);

                }

            } catch (IOException ex)

            {

                ex.printStackTrace();

            }

        }

        // 如果class文件存在，系统负责将该文件转化成class对象

        if (classFile.exists())

        {

            try {

                // 将class文件的二进制数据读入数组

                byte[] raw = getBytes(classFilename);

                // 调用Classloader的defineClass方法将二进制数据转换成class对象

                clazz = defineClass(name, raw, 0, raw.length);

            } catch (IOException ie)

            {

                ie.printStackTrace();

            }

        }

        // 如果claszz为null,表明加载失败，则抛出异常

        if (clazz == null) {

            throw new ClassNotFoundException(name);

        }

        return clazz;

    }

    // 定义一个主方法

    @Test
    @SuppressWarnings("unchecked")
    public void aaaa() throws Exception

    {

        // 如果运行该程序时没有参数，即没有目标类


        // 第一个参数是需要运行的类
        CompileClassLoader cl = new CompileClassLoader();


        String progClass = null;

        System.out.println(cl.getClass().getResource("ClassLoaderrtest.java"));
        progClass = cl.getClass().getResource("ClassLoaderrtest.java").toString().substring(6);
        System.out.println(progClass);
        if(new File(progClass).exists()){
            System.out.println("11111111");
        }


        // 加载需要运行的类

        Class<?> clazz = cl.loadClass(progClass);

        // 获取需要运行的类的主方法

        Method main = clazz.getMethod("test", (new String[0]).getClass());

        main.invoke(null, null);


    }


}
