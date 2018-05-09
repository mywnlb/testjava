package test.util.annotation;

import java.lang.reflect.Field;

/**
 * Created by lb on 2018/5/8.
 */
public class SortableFiled {
    private FiledMeta filedMeta;
    private Field field;
    private String name;
    private Class<?> type;

    public SortableFiled() {
    }
    public SortableFiled(FiledMeta meta,Field field) {
        super();
        this.filedMeta = meta;
        this.field = field;
        this.name = field.getName();
        this.type = field.getType();
    }

    public SortableFiled(FiledMeta meta,String name,Class<?> type) {
        super();
        this.filedMeta = meta;
        this.name = name;
        this.type = type;
    }

    public FiledMeta getFiledMeta() {
        return filedMeta;
    }

    public void setFiledMeta(FiledMeta filedMeta) {
        this.filedMeta = filedMeta;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}
