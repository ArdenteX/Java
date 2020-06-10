/**
 * 学习Java第四周
 * @author ArdentXu
 *本周所学内容
 * final的用法
 * 多态(重点)
 * 协变返回类型
 * 向下转型*/
import static XuhongT.Print.*;
public class WeekF {
    public static void main(String[] args){
        print("final");
        poly a = new poly();
        a.f();
        print("多态");
        Realize b = new Realize();
        b.judge();
        Apple SG = new Pear();
        print("static没有多态性");
        SG.StaticApple();
        print("结构体多态的声明顺序");
        new Dinner();
        print("协变返回类型");
        Mill m = new Mill();
        Grain g = m.process();
        print(g);
        m = new WheatMill();
        g = m.process();
        print(g);
    }
}

/*final用法
* private 就包含在final里面
* final可以说是锁定 关键词有final的都不能改变*/

final class poly{       //final类 不可继承
    final int a = 1;    //final字段 一定要先赋值 不然会报错
    final void f(){     //final方法 不可以被覆盖
        print(a);
    }
}

//多态 java的特性之一 应用在继承里面
class Apple{
    static void StaticApple(){      //静态不能为多态   不会被覆盖
        print("APPLE");
    }
    public void f(){
        print("this is a apple");
    }
}

class Pear extends Apple{
        static void StaticApple(){
            print("PEAR");
        }
        public void f(){
        print("this is a pear");
    }
}
class Realize{
    void judge(){
        Apple[] a = {new Pear(),new Apple()};
        for(Apple b : a){
            b.f();
        }
    }
}
//结构体与多态 结构体算是隐式的static
//结构体多态中的声明顺序
class Breakfast{
    Breakfast(){
        print("Breakfast");
    }
}
class Lunch extends Breakfast{
    Lunch(){
        print("Lunch");
    }

}
class AfternoodTea{
    AfternoodTea(){
        print("AfternoodTea");
    }
}
class Dinner extends Lunch{
    private AfternoodTea t = new AfternoodTea();
    public Dinner(){
        print("Dinner");
    }
}

//协变返回类型
class Grain{
    public String toString(){
        return "Grain";
    }
}
class Wheat extends Grain{
    public String toString(){
        return "Wheat";
    }
}
class Mill{
    Grain process(){
        return new Grain();
    }
}
class WheatMill extends Mill{
    Wheat process(){
        return new Wheat();
    }
}


