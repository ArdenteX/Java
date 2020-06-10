/**
 * @author ArdentXu
 * 学习java的第三周
 * 这周主要学习了：
 * 类库
 * 访问权限
 * 组合
 * 继承
 * 复用*/
//类库 有一点要注意的是 类库里面没有main函数且要配置classpath环境变量 其他的和正常的类一样 要用 import static
import java.util.Scanner;

import static XuhongT.Print.print;

public class WeekThree {
    public static void main(String[] args){
        print("Hello World");
        Scanner son = new Scanner(System.in);
        Power x = new Power();
        print("请输入x.a");
        x.a = son.nextInt();
        print("请输入x.b");
        x.b = son.nextInt();
        x.educe();
        print("请输入要兑换的币种(US YEN KRW):");
        String s = son.next();
        print("请输入人民币金额：");
        Count a = new Count(son.nextDouble());
        a.Conversion(s);
    }
}
/*访问权限有 public protect private 和包访问权限，没有在对象之前加关键字的都默认为包访问权限，在类库中 可将不想提供给客户端程序员的
对象设置为private*/
class Power{
    //public class ... 只能有一个public class
    int a,b;
    private int plus(int a,int b){  //这个方法对于这个类之外的都不可用 但可以给本类内的其他方法调取
        return a + b;
    }
    public void educe(){
        print(plus(a,b));
    }
}
//组合 用组合的方式写汇率兑换
enum Currency{
    US,YEN,KRW;
}
class Judge{
    Currency judge(String s){
        print("Your select is "+s);
        switch(s){
            case "US":return Currency.US;
            case "YEN":return Currency.YEN;
            case "KRW":return Currency.KRW;
        }
        return null;
    }
}
class Count{
    double num;
    Count(double a){
        num = a;
        print("输入人民币为："+num);
    }
    Judge k = new Judge();          //组合的使用方法
    void Conversion(String s){
        if(k.judge(s) == Currency.US){
            num = num / 6.9906;
            print("兑换后的金额为："+num);
        }
        else if(k.judge(s) == Currency.KRW){
            num = num / 0.005825;
            print("兑换后的金额为："+num);
        }
        else if(k.judge(s) == Currency.YEN){
            num = num / 0.06469;
            print("兑换后的金额为："+num);
        }
        else if(k.judge(s) != Currency.YEN && k.judge(s) != Currency.KRW && k.judge(s) != Currency.US){
            print("Not Support this Currency");
        }

    }
}
    //继承及其复用 即继承和组合一起用
class inherit extends Count{
        inherit(double a) {
            super(a);
        }
        public void pr(){
            print("this is a extends class");   /*这个类可以看成现有类的延申 他具有现有类的所有方法 这个类里的方法也是给现有类的
                                                  补充*/
        }
    }