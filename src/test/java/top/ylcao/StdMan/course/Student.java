package top.ylcao.StdMan.course;

public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("Student: " + name + " " + age);
    }

}
