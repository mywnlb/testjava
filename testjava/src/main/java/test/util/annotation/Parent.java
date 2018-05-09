package test.util.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lb on 2018/5/8.
 */
public class Parent<T> {
    private Class<T> entity;
    public Parent(){
        init();
    }

    @SuppressWarnings("unchecked")
    public List<SortableFiled> init(){
        List<SortableFiled> list = new ArrayList<SortableFiled>();
        System.out.println(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments());
        System.out.println(((ParameterizedType)getClass().getGenericSuperclass()).getOwnerType());
        System.out.println(((ParameterizedType)getClass().getGenericSuperclass()).getRawType());

        entity = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if(this.entity !=null){
            Field[] fields = entity.getDeclaredFields();

            for(Field f :fields){
                FiledMeta meta = f.getAnnotation(FiledMeta.class);
                if(meta!=null){
                    SortableFiled sf =new SortableFiled(meta,f);
                    list.add(sf);
                }
            }

        }
        return list;
    }
}
