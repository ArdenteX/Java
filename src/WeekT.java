import java.util.Scanner;

public class WeekT {
    /**
     * 学习java的第二周
     * 学习了：
     * 类似goto的用法 break和continue的标签(带冒号的)
     * 结构体
     * 结构体重载与方法重载
     * static用法
     * this的三种用法
     * 初始化与清理
     * 枚举enum*/
    public static void main(String[] args){
        Scanner sen = new Scanner(System.in);
        //结构体
        new Text();
        new Flower();
        String x = sen.next();
        new Flower(x);
        Trans a = new Trans(0);
        a.info().info().info().printf();
        a.f1();
        new Init();
        new Init(2);

        /*数组
        * java的数组和c的不同就是相同内容的两个数组是一样的
        * 也就是说改变随意一个，另外一个也会被改变  */
        int[] b1 = {1,2,3,4,5};
        int[] b2;
        b2 = b1;
        for(int i = 0;i<b1.length;i++){
            b2[i] += 1;
        }
        for(int i = 0;i < b1.length;i++){
            System.out.println("b1["+i+"] = "+b1[i]);
        }
        VarEle.f1(1,2,3,4,5,6);
        VarEle.f1("I Love Java",1,2,3,4,5,6);
        for(RMB s : RMB.values()){
            System.out.println(s + ", ordinal "+s.ordinal());
        }
        for(RMB s : RMB.values()){
            Bui sun = new Bui(s);
            sun.Biu();
        }
    }
}
    class Flower{
    String sen;
    Flower(){
        System.out.println("This is a Flower and it is so "); //无参结构体
    }
    Flower(String sen){
        this.sen = sen; //this的用法之一,this.a表示实参的a
        System.out.println(this.sen); //有参结构体与重载 方法与之类似
    }
}
    //static的用法
    class Text{
        static int a;
        static{
            a = 70;                         //显示静态初始化
            System.out.println("a = "+a);   //调用这个类的结构体时，总是会先调用static花括号里的东西且是一次性的
        }
        Text(){
            new Flower(); //两个类就这样连接在一起
        }

    }
    //this
    class Trans{
        Trans l;
        int i = 0;
        void f(Trans k){
            new Text();
        }
        void f1(){
            System.out.println("this is first call:");
            f(this);
            System.out.println("and this is second call:");
            f(l);
        }
        Trans(int i){
            this.i = i;
        }
        Trans info(){
            i++;
            return this; //this可以用作返回值 this表示当前对象 即返回当前对象
        }
        void printf(){System.out.println("i = "+i);}
    }
    /*
    * 初始化
    * 前面的static也是初始化的一部分
    * 接下来是非静态实例初始化
    * 其实和static差不多*/
    class Init{
        int a1;
        int a2;
        {
            a1 = 1;
            a2 = 2;
            System.out.println("is in brace");
        }
        Init(){
            System.out.println("this class is about initialize");
        }
        Init(int a){
            System.out.println("this num is:"+a);
        }
    }

    //可变参数
    class VarEle{
        static void f1(int a,Object... args){     //除了Object外 也可以用其他的类型 自动包装的如Integer也可以 很实用
            System.out.println("a = "+a);
            System.out.println("this is the first method");
            for(Object s : args){
                System.out.println("s = "+s);
            }
        }
        static  void f1(String a,Object... args){       //可变参数重载时，要保持一致的参数列表即相同数量的形式参数 但不要求参数都一致
            System.out.println("this is the second method");
            System.out.println(a);
            for(Object s : args) {
                System.out.println("s = " + s);
            }
        }
    }

    //枚举
    enum RMB{
        UNIT,DECADE,HUNDREDS
    }
    class Bui{
        RMB degree;
        Bui(RMB degree){this.degree = degree;};
        void Biu(){
            switch (degree){
                case UNIT:System.out.println("绿色和紫色的毛爷爷");break;
                case DECADE:System.out.println("蓝色，黄色，青色的毛爷爷");break;
                case HUNDREDS:System.out.println("红色的毛爷爷！！！！");break;
            }
        }
    }



