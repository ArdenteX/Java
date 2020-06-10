import java.lang.reflect.Array;
import java.util.*;
import static XuhongT.Print.*;
import static XuhongT.Stack.*;
/**
 * @author ArdentXu
 * 学习Java第7周
 * 本周学习：
 * 容器——实现保存不知道多少数量的对象
 * 基本类型是List set Queque Map
 * set 要求不能重复
 * Queque就是c++中的队列
 * Map有键和数值
 * 1.泛型在容器中的应用
 * 2.添加一组数组
 * 3.输出
 * 4.List
 * 5.Linklist实现栈
 * 6.迭代器
 * 7.set
 * 8.Map
 * 9.Queque
 * 10.foreach与迭代器*/
class Apple1{};
class Pear1 extends Apple1{};
class CollectionStudy {
    public void Collect() {
        //用泛型来让Collection知道要储存什么类型的对象，该对象的子类也可以被储存
        Collection<Apple1> arr = new ArrayList<Apple1>();
        LinkedList<Integer> Lista = new LinkedList<Integer>();
        Integer[] inte = {1, 2, 3, 4, 5};
        arr.add(new Pear1());
        arr.add(new Apple1());
        //输入一组数组
        Collections.addAll(Lista, inte);     //一般情况下用这个方法，记住是Collections!!!!!
        //输出
        print(Lista);
        print(arr);
    }

    static Collection Collect(Collection<Integer> arr) {
        Integer[] intg = {1, 1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 1};
        Collections.addAll(arr, intg);
        print(arr);
        return arr;
    }

    public static void StuLList() {
        List<String> ls = new LinkedList<String>();
        String[] a = ("rat, hat, nose, hope").split(", ");
        Collections.addAll(ls, a);
        print("1: " + ls);
        print("2: " + ls.contains("hat"));            //查找“hat”是否在ls中
        print("3: " + ls.remove("hat"));           //删除
        print("4: " + ls);
        print("5: " + ls.get(1));                     //获取但不删除
        print("6: " + ls.add("drum"));                //在尾部插入
        print("7: " + ls.add("drum"));                //在尾部插入
        print("8: " + ls.indexOf("drum"));            //查找对象的下标，似乎是第一个的下标
        print("9: " + ls);
        List<String> sub = ls.subList(0, 3);         //截取目标容器的片段
        print("10: " + sub);
        List<String> copy = new ArrayList<String>(ls);
        print("copy: " + copy);
        copy.retainAll(sub);                        //查找交集(要在ArrayList中搞),只保留交集部分
        print("11: " + copy);
        print("ls: " + ls);
        Collections.sort(ls);
        print("12: " + ls);
        print("13: " + ls.isEmpty());                 //判断是否为空
        ls.clear();                                 //清空
        print("14: " + ls.isEmpty());
        print("15: " + ls);
    }

    //迭代器，实现了完全解耦
    public static void Iteration(Iterator<String> inte) {
        int i = 0;
        while (inte.hasNext()) {
            String I = inte.next();
            printb(i + ": " + I + " ");
            i++;
        }
        print(" ");
    }
}
//关于栈的实现
class StackStudy{
    public static void stastudy(){
        Stack<Integer> SS = new Stack<Integer>();
        Random ran = new Random();
        for(int i = 0;i<7;i++){
            SS.push(ran.nextInt(40));
        }
        SS.toString();
        print(SS.empty());
        print(SS);
        print("The first is: "+SS.peek());
        while(!SS.empty()){
            print(SS.pop());
        }
    }
}
class MapStudy{
    public static void Mapx(){
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        {
            map.put("Peter",Arrays.asList("Huniu","ALex","das"));
            map.put("Keter",Arrays.asList("Wangcai,Afu,Wuyazuofeiji".split(",")));
        }
        print("People: "+map.keySet());
        print("Pet: "+map.values());
        for(String s : map.keySet()){
            print(s+"has:  ");
            for(String s1 : map.get(s)){
                print("  "+s1);
            }
        }

    }
}
class QuequeStudy{
    public static void quequestudy(){
        Random ran  = new Random(47);
        PriorityQueue<Integer> pi = new PriorityQueue<Integer>();
        for(int i = 0;i<10;i++){
            pi.offer(ran.nextInt());
        }
        print(pi);

    }
}

public class WeekSeven {
    public static void main(String[] args) {
        //初始化,创建对象
        CollectionStudy cs = new CollectionStudy();
        String[] a = ("rat, hat, nose, hope").split(", ");
        Collection<String> arr = new ArrayList<String>();
        Collections.addAll(arr, a);
        LinkedList<String> LL = new LinkedList<String>(arr);
        LinkedHashSet<String> LH = new LinkedHashSet<String>(arr);
        TreeSet<String> TS = new TreeSet<String>(arr);
        HashSet<String> HS = new HashSet<String>(arr);

        //不同的打印结果
        cs.Collect();
        print("LinkedList:");
        cs.Collect(new LinkedList<Integer>());
        print("LinkedHashSet:");
        cs.Collect(new LinkedHashSet<Integer>());
        print("TreeSet:");
        cs.Collect(new TreeSet<Integer>());
        print("HashSet:");
        cs.Collect(new HashSet<Integer>());

        //各种操作
        CollectionStudy.StuLList();

        //迭代器
        CollectionStudy.Iteration(arr.iterator());
        CollectionStudy.Iteration(LH.iterator());
        CollectionStudy.Iteration(TS.iterator());
        CollectionStudy.Iteration(HS.iterator());
        CollectionStudy.Iteration(LL.iterator());

        //ListIterator——Iterator的升级版
        List<String> liS = new LinkedList<String>(arr);
        ListIterator it = liS.listIterator();
        while (it.hasNext()) {
            printb(it.next() + ": " + it.previousIndex() + ", " + it.nextIndex() + " ");
        }
        print(" ");
        it = liS.listIterator(3);   //截取
        //LinkedList栈
        StackStudy.stastudy();
        //Map的一些实现
        MapStudy.Mapx();
    }
}

