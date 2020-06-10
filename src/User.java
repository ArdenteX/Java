import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class User {
    private String username;   //用户名
    private double leftMoney; //余额

    //构造方法
    public User(){}
    //带全参数的构造方法
    public User(String username, double leftMoney) {
        this.username = username;
        this.leftMoney = leftMoney;
    }
    //对属性的封装: 定义set和get方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }
    //定义一个展示方法
    public  void show(){
        System.out.print("用户名："+ this.username  + "     余额："+ this.leftMoney);
    }

}
class Member extends User {
    //添加构造方法
    public Member(){}
    public Member(String username,double leftMoney){
        //通过super调用父类构造方法
        super(username, leftMoney);
    }
    //打开红包，就是从集合中，随机取出一份，保存到自己的余额中
    public void openRedPacket(ArrayList<Double> list){
        //创建Random对象
        Random r=new Random();
        //随机生成一个角标
        int index=r.nextInt(list.size());
        //移除一个金额
        Double money=list.remove(index);
        //直接调用父类方法，设置到余额
        setLeftMoney(this.getLeftMoney()+money);
    }
}
class GroupMaster extends User {
    //添加构造方法
    public GroupMaster(){}
    public GroupMaster(String username,double leftMoney){
        //通过super调用父类构造方法
        super(username,leftMoney);
    }
    /*1.获取群主余额，是否够发红包。
            不能则返回null，并提示。
            能则继续
      2.修改群主余额
      3.拆分红包
           如果能整除就平均分
           如果不能整除，那么就把余数分给最后一份
     */
    public ArrayList<Double> send(int money, int count) {
        //获取群主余额
        double leftMoney = this.getLeftMoney();
        if (money > leftMoney) {
            return null;
        }
        //修改群主余额
        setLeftMoney(leftMoney - money);
        //创建一个集合，保存等份金额
        ArrayList<Double> list = new ArrayList<>();
        //扩大100倍，相当于折算成分“为”单位，避免小鼠运算损失精度的问题
        money = money * 100;
        //每份的金额
        int m = money / count;
        //不能整除的余数
        int l = money % count;
        //无论是否整除，n-1份，都是每份的等额金额
        for (int i = 0; i < count - 1; i++) {
            //缩小100倍，折算成“元”
            list.add(m / 100.0);
        }
        //判断是否整除
        if (l == 0) {
            //能整除，最后一份金额，与之前每份金额一致
            list.add(m / 100.0);
        } else {
            //不能整除，最后一份金额是之前的每份金额+余数金额
            list.add((m + 1) / 100.0);
        }
        //返回金额
        return list;
    }

}
