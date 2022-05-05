package top.ylcao.StdMan.course;

public class TestRun {

    public static void main(String[] args) {
        Student a = new Student("老张", 18);
        UnderStudent b = new UnderStudent("小张", 18, "计算机");

        a.show();
        b.show();

    }
}
