
    import java.io.IOException;
    import java.util.*; /*星号代表用类库的所有类型 就不用一个一个声明*/
    import java.math.*;
    /**The first thinking in java example program.//javadoc的一些实践
     * Displays a string and today's date.
     * @author ArdentX
     * */
    public class CaoGao {
        /**
         * Entry point to class & application.
         * @param args 存储命令行参数
         *             * java第一周
         */
        public static void main(String[] args) throws IOException {
            System.out.println("现在时间为：");
            System.out.println(new Date());
            //int a = System.in.read();
            //System.out.print(""+a);
            Dog k1 = new Dog();//声明引用要在类里面
            Dog k2 = new Dog();
            k1.name = "spot";
            k1.says = "Ruff!";
            k2.name = "scruffy";
            k2.says = "Wurf";
            System.out.println("狗:" + k1.name + "叫声：" + k1.says);
            System.out.println("狗:" + k2.name + "叫声：" + k2.says);
            int i1 = 0xffaa;//0x为16进制表示方法;
            int i2 = 067676;//0+（1-7）表示8进制;
            System.out.println("" + Integer.toBinaryString(i1));//Integer.toBinaryString()可以讲八进制或16进制的数转化成2进制
            System.out.println("\n" + Integer.toBinaryString(i2));
            Random rand = new Random();
            int a = rand.nextInt(100);
            int b = rand.nextInt(100);
            Boolean judge = (a > b);
            if (judge == true) {
                System.out.println("a>b");
            } else {
                System.out.println("b<a");
            }
            //操作符分为逻辑操作符&& 按位操作符& 移位操作符>>> >> >>>=
            //逻辑操作符
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("a>b is " + (a > b));

            //按位操作符 比较少用
            int c = 0xaa;
            int d = 0xbb;
            System.out.println("c = " + Integer.toBinaryString(c));
            System.out.println("d = " + Integer.toBinaryString(d));
            System.out.println("c & d = " + (c & d));
            System.out.println("c | d = " + (c | d));
            System.out.println("c ~ d = " + (c ^ d));

            //移位操作符 基于二进制 只能在int基础类型中使用
            int e = 24;
            int f = -1;
            System.out.println(e);
            e <<= 3;
            System.out.println(e);
            System.out.println(Integer.toBinaryString(e));
            e = 00001000;
            System.out.println(e);
            e >>= 3;
            System.out.println(e);
            System.out.println("int f = " + f);
            System.out.println("binary f = " + Integer.toBinaryString(f));
            f >>>= 3;
            System.out.println("int f = " + f);
            System.out.println("binary f = " + Integer.toBinaryString(f));
            System.out.println(24 >> 2*2);

            //三目运算符 ?
            Test a1 = new Test();
            System.out.println("a = " + a);
            System.out.println("a = " + a1.plus(a));

            //Foreach 与 math,random(); <- 返回一个double类型的[0，1)的随机数
            int j = 0;
            int arr[] = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = rand.nextInt(100) + 1;
            }
            for (int l : arr) {
                System.out.println("arr[" + j + "]= " + l);
                j++;
            }
            for (char L : "I Love huang Bo Xue".toCharArray()) {
                System.out.print(L + " ");
            }
            System.out.println("");
            /**
             * Java 学习第二周
             */
            //输入 数字/字符串
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextInt()) {
                int i = scan.nextInt();
                System.out.println("The number is " + i);
            }
            //构造体与重载
            new Tree();
            String L = "I Love Huang Bo Xue";
            new Tree(L);

            //This用法
            Leaf x = new Leaf();
            x.increment().increment().increment().increment().increment().print();
            new Leaf(2);
        }
    }
    class Dog{
         String says;
         String name;

    }
    class Test{
        Random a = new Random();
        int plus(int a){
            return a > 50 ? a * 100 : a *50;//三目运算符的用法
        }
    }
    class Tree{
        int num;
        Tree(){
            System.out.println("This is a tree");  //构造体
        }
        Tree(String x){
             System.out.println("I want to say " +x);   //构造体重载
        }
        void info(){
            //方法
        }
        void info(int num){
            this.num = num;//方法重载 this的用法之一 this.num表示类内的对象num ，num表示形式参数;
            System.out.println("this.num = "+this.num);
        }
    }
    class Leaf{
        Leaf(){
            System.out.println("这是一个构造体");
        }
        Leaf(int a){
            System.out.println("这是一个重载构造体 a = "+a);
        }
        int i = 0;
        Leaf increment(){
            i++;
            return this; //this表示当前对象 也就是对象 可以当作返回值
        }
        void print(){
            System.out.println("i = "+i);
        }
    }

