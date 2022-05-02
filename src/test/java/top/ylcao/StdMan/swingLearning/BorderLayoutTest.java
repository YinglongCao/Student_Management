package top.ylcao.StdMan.swingLearning;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame{
    JButton northButton = new JButton("北边的按钮");
    JLabel southLabel = new JLabel("南边的标签");
    JRadioButton westRadioButton = new JRadioButton("西边的单选按钮");
    JTextArea eastArea = new JTextArea("输入内容", 10, 20);
    JButton centerButton = new JButton("中间的按钮");


    public BorderLayoutTest() {
        super("测试边界布局");
        Container contentPane = getContentPane();
        // 设置布局管理器
        contentPane.setLayout(new BorderLayout());
        contentPane.add(northButton, BorderLayout.NORTH);
        contentPane.add(southLabel, BorderLayout.SOUTH);
        contentPane.add(westRadioButton, BorderLayout.WEST);
        contentPane.add(eastArea, BorderLayout.EAST);
        // 边界布局默认是中间，可以去掉BorderLayout.CENTER参数
        contentPane.add(centerButton, BorderLayout.CENTER);

        setSize(600, 400);
        setLocationRelativeTo(null);

        setVisible(true);


    }

}
