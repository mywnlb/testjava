package test.util.Enum;

import org.apache.commons.beanutils.converters.AbstractConverter;

/**
 * Created by lb on 2018/3/6.
 */
public class EnumConverter extends AbstractConverter {
    //枚举类型
    private final Class<?> enumclass;

    public EnumConverter(Class<?> enumclass){
        this(enumclass,null);
    }
    public EnumConverter(Class<?> enumclass,Object defaultValue){
        super(defaultValue);
        this.enumclass = enumclass;
    }

    /**
     * 转换为枚举对象
     *
     * @param type
     *            类型
     * @param value
     *            值
     * @return 枚举对象
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        String stringValue = value.toString().trim();
        return Enum.valueOf(type,stringValue);
    }

    @Override
    protected Class getDefaultType() {
        return this.enumclass;
    }

    /**
     * 转换为字符串
     *
     * @param value
     *            值
     * @return 字符串
     */
    protected String converToString(Object value){
        return value.toString();
    }
}
