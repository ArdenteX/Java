
package XuhongT;
public class Print {
    //有参数列表且分行
    public static void print(Object obj){
        System.out.println(obj);
    }
    //没有参数列表
    public static void print(){
        System.out.println();
    }
    //不分行的打印 有参数列表
    public static void printb(Object obj){
        System.out.print(obj);
    }
}

