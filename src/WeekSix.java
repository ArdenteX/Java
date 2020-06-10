/**
 * @author ArdentXu
 * java学习的第六周
        * 内部类：
        * 创建内部类
        * 链接到外部类
        * 内部类与向上转型
        * 匿名内部类
        * 工厂方法
        * 嵌套类
        * 闭包与回调
        * 命令设计模式（将内部类（new xxxx）封装成数组，一次创建后实现不同的东西）
        * 内部类继承
        * 局部内部类（与匿名内部类差不多 在需要构造体/重载构造体的时候使用，一般不会用到）*/


import static XuhongT.Print.*;
//内部类
interface ComputerU{
    void IsUseful(String s);
}
//匿名内部类的工厂设计模式
interface Computerx{
    void Function();
}
interface ComputerFactory{
    Computerx GetComp();
}
class Graphics implements Computerx{
    public void Function(){
        print("Provide graphical interface.");
    }
    public static ComputerFactory factor(){
        return new ComputerFactory(){
            public Computerx GetComp(){
                return new Graphics();
            }
        };
    }
}
class MemoryCard implements Computerx{
    public void Function(){
        print("Storage");
    }
    public static ComputerFactory factory(){
        return new ComputerFactory(){
           public Computerx GetComp(){
                return new MemoryCard();
            }
        };
    }
}
class Factory{
    public static void select(ComputerFactory CpFact){
        Computerx Cx = CpFact.GetComp();
        Cx.Function();
    }
}

class Computer{
    private String s;
    void Operation(){
                print("Use keyboard and mouse");
            }
    class CPU{
        public Computer outer(){
            return Computer.this;
        }
        public void function(){
            s = "Control computer";     //内部类有访问外部类所有字段方法的权利，不需要特殊语句
            //Operation();
            print(s);
        }
    }
    class Use implements ComputerU {
        private String s;

        public void IsUseful(String s) {
            this.s = s;
            print(s);
        }
    }
    static class NotDefiniton{
        //此类与外部类没有关系 无法直接使用外部类除static外的方法，数据。
    }
    //匿名内部类
    public static Computer Display(){                   //这个方法的意思是：创建一个继承自Computer的匿名内部类
            return new Computer(){
            {
                print("This is a anonymous inner class");
            }
            public void Operation(){
                print("Display show everything what you want");

            }
        };
    }
    //向上转型
    public ComputerU computeru(){
        return new Use();
    }
    //创建对象
    public CPU Cp(){
        return new CPU();
    }

}
class CPUplus extends Computer.CPU{         //继承内部类的必须语法 直接选定内部类就可以覆盖内部类的方法，现在这样就是可以的
    CPUplus(Computer co){
        co.super();
    }
    public void function(){
        super.function();
        print("This is a extends class");
    }

}

public class WeekSix {
    public static void main(String[] args){
            Computer com = new Computer();
            //Computer.CPU cpu = com.new CPU();       //创建内部类对象（使用.new）
            Computer.CPU cpu = com.Cp();              //创建内部类对象（使用.this，这个没有.new 来的直接，一般用new)
            cpu.outer().Operation();
            cpu.function();
            ComputerU CU = com.computeru();           //向上转型：基类类型，下一层的对象,意思是左边是基类右边是下一层类
            CU.IsUseful("Very Useful!");
            com = Computer.Display();
            com.Operation();
            Factory fact = new Factory();
            fact.select(Graphics.factor());
            fact.select(MemoryCard.factory());
            CPUplus plus = new CPUplus(new Computer());
            plus.function();

    }
}
