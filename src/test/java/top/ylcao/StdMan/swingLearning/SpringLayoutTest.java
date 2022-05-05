package top.ylcao.StdMan.swingLearning;

import javax.swing.*;
import java.awt.*;

public class SpringLayoutTest extends JFrame {
    // 弹簧布局SpringLayout

    // 设置jPanel的布局管理器为SpringLayout
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);

    JLabel titleLabel = new JLabel("文章标题");
    JTextField titleTxt = new JTextField();
    JLabel authorLabel = new JLabel("作者");
    JTextField authorTxt = new JTextField();
    JLabel contLabel = new JLabel("请输入内容");
    JTextArea contArea = new JTextArea(4, 10);

    public SpringLayoutTest() {
        super("弹簧布局");

        Container contentPane = getContentPane();
        // 加入到jPanel中
        jPanel.add(titleLabel);
        // 设置titleTxt设置大小
        titleTxt.setPreferredSize(new Dimension(200, 30));
        jPanel.add(titleTxt);

        jPanel.add(authorLabel);
        authorTxt.setPreferredSize(new Dimension(200, 30));
        jPanel.add(authorTxt);

        jPanel.add(contLabel);
        jPanel.add(contArea);

//        SpringLayout：布局管理器
        // 获取titleLabel宽度
        Spring titleLabelWidth = Spring.width(titleLabel);
        Spring titleTxtWidth = Spring.width(titleTxt);
        springLayout.putConstraint(SpringLayout.WEST, titleLabel, -(Spring.sum(Spring.sum(titleLabelWidth, titleTxtWidth), Spring.constant(20)).getValue() / 2), SpringLayout.HORIZONTAL_CENTER, jPanel);



        // SpringLayout.Constraints:使用弹簧布局的容器里面的组件的布局约束，每个组件对应一个
        // Spring：可以理解为一个可以进行四则运算的整数

        // 设置titleLabel距离顶边和左边的距离
        // 获取titleLabel的约束
        SpringLayout.Constraints titleLabelC = springLayout.getConstraints(titleLabel);
        // 对约束进行位置设置
//        titleLabelC.setX(Spring.constant(150));
        titleLabelC.setY(Spring.constant(20));

        // 设置边界的第一种写法，比较复杂
        // 设置titleTxt的西边距离titleLabel东边20px，北边相同
        // 获取titleTxt的约束
        SpringLayout.Constraints titleTxtC = springLayout.getConstraints(titleTxt);
        // 获取titleLabel的东边约束
        Spring titleLabelEastConstraint = titleLabelC.getConstraint(SpringLayout.EAST);
        // 设置titleTxtC约束的西边为titleLabel东边约束加上20px
        titleTxtC.setConstraint(SpringLayout.WEST, Spring.sum(titleLabelEastConstraint, Spring.constant(20)));
        // 设置titleTxtC约束北边为和titleLabel北边约束
        titleTxtC.setConstraint(SpringLayout.BASELINE, titleLabelC.getConstraint(SpringLayout.BASELINE));


        // 设置边界的第二种写法，相对简单
//        e1:要设置组件的边界
//        c1:要设置的组件
//        pad:距离值
//        e2:参照的组件的边界名
        //c2:参照物（组件）
        // 设置authorLabel，东边和titleLabel对齐，北边距离titleLabel南边20px
        springLayout.putConstraint(SpringLayout.EAST, authorLabel, 0, SpringLayout.EAST, titleLabel);
        springLayout.putConstraint(SpringLayout.NORTH, authorLabel, 20, SpringLayout.SOUTH, titleLabel);

        // 设置authorTxt
        springLayout.putConstraint(SpringLayout.WEST, authorTxt, 0, SpringLayout.WEST, titleTxt);
        springLayout.putConstraint(SpringLayout.BASELINE, authorTxt, 0, SpringLayout.BASELINE, authorLabel);

        // 设置内容Label和内容Txt
        springLayout.putConstraint(SpringLayout.EAST, contLabel, 0, SpringLayout.EAST, titleLabel);
        springLayout.putConstraint(SpringLayout.NORTH, contLabel, 20, SpringLayout.SOUTH, authorLabel);

        springLayout.putConstraint(SpringLayout.WEST, contArea, 0, SpringLayout.WEST, authorTxt);
        springLayout.putConstraint(SpringLayout.NORTH, contArea, 0, SpringLayout.NORTH, contLabel);

        springLayout.putConstraint(SpringLayout.SOUTH, contArea, -20, SpringLayout.SOUTH, jPanel);
        springLayout.putConstraint(SpringLayout.EAST, contArea, -20, SpringLayout.EAST, jPanel);



        contentPane.add(jPanel);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
        setVisible(true);
    }


    public static void main(String[] args) {
        new SpringLayoutTest();
    }
}
