package top.ylcao.StdMan.course;

public class UnderStudent extends Student {
    String degree;

    public UnderStudent(String name, int age, String degree) {
        super(name, age);
        this.degree = degree;
    }

    public void show() {
        System.out.println("UnderStudent: " + name + ", " + age + ", " + degree);
    }

}
