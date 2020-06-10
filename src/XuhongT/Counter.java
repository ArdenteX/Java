package XuhongT;

import java.util.HashMap;
import java.util.Map;

//利用递归对Class对象进行计数
public class Counter extends HashMap<Class<?>,Integer> {
    private Class<?> baseType;
    public Counter(Class<?> baseType){
        this.baseType = baseType;
    }
    public void Count(Object obj){
        Class<?> Type = obj.getClass();
        if(!baseType.isAssignableFrom(Type)){
            throw new RuntimeException(obj+"incorrect Type: " + Type +", should be type or subtype of"+baseType);
        }
    }
    public void ClassCount(Class<?> Type){
        Integer quantity = get(Type);
        put(Type,quantity == null ? 1 : quantity + 1);
        Class<?> Superclass = Type.getSuperclass();
        if(Superclass != null && baseType.isAssignableFrom(Superclass)){
            ClassCount(Superclass);
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>,Integer> pair : entrySet()){
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(",");
        }
        result.delete(result.length() - 2,result.length());
        result.append("}");
        return result.toString();
    }
}
