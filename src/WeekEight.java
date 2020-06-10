import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static XuhongT.Print.*;
/**
 * @author ArdentXu
 * Study Java Week Eight
 * 学习了String章节，主要有：
 * StringBulider
 * 格式化输出，即C语言类型的输出
 * Formatter类
 * 正则表达式
 * Patter与Matcher*/

//在构造复杂的toString时候使用StringBuilder
class UsingStringBuilder{
    Random ran = new Random(47);
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0;i<25;i++){
            sb.append(ran.nextInt(200));
            sb.append(", ");
        }
        sb.delete(sb.length() - 2,sb.length());
        sb.append("]");
        return sb.toString();
    }
}
//只需使用一次format时用String.format
class UsingFormatter{
    double Total = 0;
    Formatter f = new Formatter(System.out);
     void Begin(){
        f.format("%-15s %5s %10s\n","Item","Qty","Price");
        f.format("%-15s %5s %10s\n","----","---","-----");
    }
    void Content(String s,int Qty,double price){
         f.format("%-15.15s %5d %10.2f\n",s,Qty,price);
         Total += price;
    }
    void PrintTotal(){
         f.format("%31s\n","----");
         f.format("%-15s %17.2f\n","Total",Total);
    }

}
//正则表达式
class RegularExpression{
    String a = "I Love Java and be " +"Willing to Study ";
    void Research(){
            print("12345".matches("-?\\d+"));
            print("-12345".matches("-?\\d+"));
            print("abcd".matches("-?\\d+"));
            print("Split的运用");
            print(Arrays.toString(a.split(" ")));
            print(a.replace("Java","Huang Bo Xue"));
    }
    void ResearchPattern(){
        Matcher m = Pattern.compile("\\w+").matcher(a);
        while(m.find()){
            printb(m.group() + " ");
        }
    }
}

public class WeekEight {
    public static void main(String[] args){
        UsingStringBuilder usb = new UsingStringBuilder();
        UsingFormatter ug = new UsingFormatter();
        print(usb);
        ug.Begin();
        ug.Content("Thinking of Java",1,78);
        ug.Content("Big Data",1,56);
        ug.PrintTotal();
        RegularExpression  reg = new RegularExpression();
        reg.Research();
        reg.ResearchPattern();
    }
}
