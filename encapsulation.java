class ABC {
    private int id;
    private String name;
    private long phno;

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPh(long phno){
        this.phno = phno;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public long getPh(){
        return phno;
    }
}

public class encapsulation{
    public static void main(String[] args) {
        ABC obj1 = new ABC();
        obj1.setId(1);
        System.out.println(obj1.getId());
    }
}