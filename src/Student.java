import java.util.Scanner;

class StringTooLongException extends Exception{};

class InheritingException{
    public void f() throws StringTooLongException{
        throw new StringTooLongException();
    }
}


class Student {
    public static void main(String[] args){
        String a;
        InheritingException inh = new InheritingException();
        Scanner scan = new Scanner(System.in);
        a = scan.next();
        while(a.length() <= 20){
            a = scan.next();
        }
        try{
            inh.f();
        }catch (StringTooLongException s){
            System.out.println("字符串长度超过20！");
        }
    }
}












































































/**abstract class Person{
    void Display(){};
    void Pay(){};
}
class Teacher extends Person{
    int pay;
    static String teacher;
    static int ClasSum;
    int BaseWage = 800;

    public void Pay(){
        pay = BaseWage + ClasSum*30;
    }
    public void Display(){
        Pay();
        System.out.println("Teacher's Name: "+teacher+" Pay: "+pay);
    }
}

class Students extends Person{
    int pay = 0;
    static int Scholarship;
    static String Student;
    public void Pay(){
        pay = Scholarship;
    }
    public void Display(){
        Pay();
        System.out.println("Student's Name: "+ Student + " Pay: "+pay);
    }
}

class PersonTest{
    public void persontest(Person per){
        per.Display();
    }
    public void judge(){
        int a = 4;
        Scanner sca = new Scanner(System.in);
        while(a != 0){
            System.out.println("Teacher/Student?(Please input 1 or 2 and 0 to exit)");
            a = sca.nextInt();
            if(a == 1){
            Teacher tea = new Teacher();
            System.out.println("Please input teacher's name: ");
            Teacher.teacher = sca.next();
            System.out.println("Please input teacher's class sum");
            Teacher.ClasSum = sca.nextInt();
            persontest(new Teacher());
            }
        else if(a == 2){
            Students sts = new Students();
            System.out.println("Please input student's name: ");
            Students.Student = sca.next();
            System.out.println("Please input student's Scholarship: ");
            Students.Scholarship = sca.nextInt();
            persontest(new Students());
            }
        }

    }
}*/

