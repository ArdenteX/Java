/**
 * @author ArdenXu;
 * java第五周;
 * 学习了接口一章;
 * 抽象类和抽象方法;
 * 接口;
 * 完全解耦;
 * 三种设计模式：策略设计模式，适配器设计模式，工厂方法设计模式;
 * 多重继承;
 * 初始化接口中的域;
 * 嵌套接口;*/
import static XuhongT.Print.*;

//抽象类和抽象方法
abstract class Language{
    private int i = 1;                //不用全部都abstract
    public abstract void speak();     //抽象方法不可以实现
}

class English extends Language{
    public void speak(){
        print("Speak English");
    }
}

class Chinese extends Language{
    public void speak(){
        print("说汉语");
    }
}

class Transform{
    Language[] a = {
            new English(),
            new Chinese()
    };
}
//接口
interface Languages{
    void Difficulty();
    void Speak();
}
interface LanguageFactory{
    Languages GetLanguage();
}

class LanguagesAdapter implements Languages{        //适配器设计模式：接受所有的接口
    Languages La;
    public void Difficulty(){
        ;
    }
    public void Speak(){
        ;
    }
    public LanguagesAdapter(Languages La){
        this.La = La;
    }
}

class Cantonese implements Languages{
    public void Difficulty(){
        print("Easy");
    };
    public void Speak(){
        print("港吔");
    };
}
class CantoneseFactory implements LanguageFactory{
    public Languages GetLanguage(){
        return new Cantonese();
    }
}

class Teochew implements Languages{
    public void Difficulty(){
            print("Very Difficulty");
    }
    public void Speak(){
            print("NNKJ");
    }
}
class TeochewFactory implements LanguageFactory{
    public Languages GetLanguage(){
        return new Teochew();
    }
}
//多重继承
interface Drum{
    void DrumVoice();
}

interface Guitar{
    void GuitarVoice();
}

class Bass{
    public Bass(){
        print("Du");
    }
}

class Instruments extends Bass      //继承了Bass，会首先编译Bass的结构体。
    implements Drum,Guitar{
    public void DrumVoice(){
        print("Dong");
    }
    public void GuitarVoice(){
        print("Deng");
    }
}

public class WeekFive {
    public static void OD(Languages fact){      //策略计划模式:动态接受不同类型,固定执行代码;
        print("策略计划模式");
        fact.Difficulty();
    }
    public static void d(Drum d){
        d.DrumVoice();
    }
    public static void g(Guitar g){
        g.GuitarVoice();
    }
    public static void LanguagesConsumer(LanguageFactory fact){
        Languages Lan = fact.GetLanguage();
        Lan.Difficulty();
        Lan.Speak();
    }
    public static void main(String[] args){
        Transform sun = new Transform();
        print("抽象类和抽象方法");
        for(Language f : sun.a){
            f.speak();
        }
        print("接口");
        OD(new Cantonese());
        print("多重继承");
        Instruments I = new Instruments();
        d(I);
        g(I);
        print("工厂方法设计模式");
        LanguagesConsumer(new CantoneseFactory());
        LanguagesConsumer(new TeochewFactory());
    }
}
