public class oops {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add(1.1f, 2.9f);
        Parent p = new Parent();
        p.setName("name");
        p.getName();
    }
}

class Calculator{
    public static void add(int a, int b){
        System.out.println(a+b);
    }
    public static void add(float a, float b){
        System.out.println(a+b);
    }
}

class Parent {
    private String name;
    private String email;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class Student{
    public void study(){
        System.out.println("studing");
    }
}

class NonMed extends Student {
    @Override
    public void study(){
        System.out.println("studing science");
    }
}