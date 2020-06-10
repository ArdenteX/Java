import XuhongT.FactoryX;

import java.lang.reflect.*;
import java.util.*;

import static XuhongT.Print.print;


/**
 * @author ArdentXu
 * 学习Java的不知道第几周了
 * 学习了Class对象（具体内容进一步完善）
 * 1.Class对象:有区别于类的对象，class对象不妨说成一系列操作，class层面的操作，比如collection 容器的操作。
 * 2.Class转型：cast（）
 * 3.RTTI有三种形式，其中第三种是instanceof/class.instanceof
 * 4.工厂注册模式
 * 5.动态代理模式*/

class Animal extends Part{
    Animal(){
        print("Animal");
    }
}

class Ant extends Animal{
    Ant(){
        print("Ant");
    }
    public static class FactoryX implements XuhongT.FactoryX<Ant>{
        public Ant create(){
            return new Ant();
        }
    }
}
class Elephant extends Animal{
    public static class FactoryX implements XuhongT.FactoryX<Elephant>{
        public Elephant create(){
            return new Elephant();
        }
    }
}

class ClassResearch{

    /**Class的各种操作*/
        ClassResearch(){
            print("Class research");
        }
        static void ClassOperation(Class<?> cc){    // “?” 称为通配符 表示 “任何事物”;
            print("ClassOperation");
            print("Class Name: "+cc.getName()+"\nIs Interface? :" + cc.isInterface());
            print("Class simple name: "+cc.getSimpleName()+ "\nClass canonical name: " + cc.getCanonicalName());
        }
        static void ClassCast(){
            //cast()只会在很少时候才会用到，不妨讲下面这段代码换成Ant ant = (Ant)an;
            print("ClassCast");
            Animal an = new Ant();
            Class<Ant> at = Ant.class;
            Ant ant = at.cast(an);
            print("at's Name: "+at.getName());
        }
    static void ClassInstanceof(Object obj,Animal animal){
        print("ClassInstanceof");
        Class<?> x = obj.getClass();
        if(x.isInstance(animal)){
            print("Yes" + " Class name: "+x.getName());
        }
    }
}
class Part{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<FactoryX<? extends Part>> PartFactory = new ArrayList<FactoryX<? extends Part>>();
    static{
        PartFactory.add(new Ant.FactoryX());
        PartFactory.add(new Elephant.FactoryX());
    }

    static Part CreateRandom(){
        Random rand = new Random(47);
        int n = rand.nextInt(PartFactory.size());
        return PartFactory.get(n).create();
    }
}
class DynamicProxy implements InvocationHandler{
    private Object Proxy;
    private DynamicProxy(Object Proxy){
        this.Proxy = Proxy;
    }
    public Object invoke(Object obj, Method method,Object[] args) throws Throwable{
        print("**** Proxy: " + Proxy.getClass()+", method:" + method+ ", args: " + args);
        if(args != null){
            for(Object arg : args){
                print(" " + arg);
            }
        }
        return method.invoke(Proxy,args);
    }
}

public class WeekNine {
    public static void main(String[] args){
        Class<? extends Animal> an = Animal.class;

        Ant ant = new Ant();
        Animal ani = new Animal();

        ClassResearch.ClassOperation(an);
        ClassResearch.ClassCast();
        ClassResearch.ClassInstanceof(ant,ani);

        for(int i = 0;i<2;i++){
            print(Part.CreateRandom());
        }
        //Animal proxy = (Animal)Proxy.newProxyInstance()   括号要填入所需要实现的接口 动态代理

        //forName 要在try块中或者抛出ClassNotFoundException的方法中使用
        try{
            Class.forName("Animal");
        }catch (ClassNotFoundException e){
            print("Can't found class!");
        }

    }
}


