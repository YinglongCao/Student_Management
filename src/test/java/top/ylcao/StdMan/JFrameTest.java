package top.ylcao.StdMan;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JFrameTest extends JFrame{
    JButton jButton;

    public JFrameTest() {
        //构造函数
        // 容器组件
        super("这是一个标题");
        // 设置大小，单位：px
        setSize(600, 400);
        // 设置关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口图标
        URL iconResource = JFrameTest.class.getClassLoader().getResource("icon.png");
        Image imageIcon = new ImageIcon(iconResource).getImage();
        setIconImage(imageIcon);
        // 大小不可改变
        setResizable(false);
//        设置居中显示，有几种方法。
//        1.
//        jFrame.setLocationRelativeTo(null);
//        2. 自己计算位置来居中
        // 获取屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int offsetX = (screenSize.width - 600) / 2;
        int offsetY = (screenSize.height - 400) / 2;
        setLocation(offsetX, offsetY);

        // 创建一个非容器组件按钮
        JButton jButton = new JButton("这是一个按钮");
        // 获取jFrame的面容面板
        Container contentPane = getContentPane();
        // 为jFrame内容面板添加组件
        contentPane.add(this.jButton);
        // 设置为可见
        setVisible(true);
    }


    public static void main(String[] args) {
        new JFrameTest();
        new BorderLayoutTest();

    }
}
