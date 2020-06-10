/**用LInkedList实现的栈
 * 更加实用且强大*/

package XuhongT;
import java.util.*;
public class Stack<T>{
    private LinkedList<T> storage = new LinkedList<T>();
    public void push(T v){
        storage.addFirst(v);
    }               //插入
    public T peak(){
        return storage.getFirst();
    }               //获取栈顶元素
    public T pop(){
        return storage.removeFirst();
    }             //删除栈顶元素并返回栈顶元素
    public boolean empty(){
        return storage.isEmpty();
    }         //确认栈空
    public String toString(){
        return storage.toString();
    }
}
