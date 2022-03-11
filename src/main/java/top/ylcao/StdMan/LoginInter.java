package top.ylcao.StdMan;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LoginInter extends JFrame {

    SpringLayout springLayout = new SpringLayout();
    JPanel loginPanel = new JPanel(springLayout);

    JLabel title = new JLabel("学生管理系统", JLabel.CENTER);
    JLabel subTitle = new JLabel("by 20计科曹应龙");
    JLabel accountLabel = new JLabel("学号");
    JTextField accountText = new JTextField();
    JLabel passwordLabel = new JLabel("密码");
    JTextField passwordText = new JTextField();
    JButton loginButton = new JButton("登陆");




    public LoginInter(){
        super("学生管理系统");
        Container contentPane = getContentPane();

        title.setFont(new Font("苹方", Font.PLAIN, 30));
        subTitle.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        Font MSYaHei = new Font("微软雅黑", Font.PLAIN, 15);
        accountLabel.setFont(MSYaHei);
        accountText.setPreferredSize(new Dimension(200, 30));
        accountText.setFont(MSYaHei);
        passwordLabel.setFont(MSYaHei);
        passwordText.setPreferredSize(new Dimension(200, 30));
        passwordText.setFont(MSYaHei);
        loginButton.setFont(MSYaHei);


        // 设置小标题在大标题下面，也就是loginPanel最上面，并水平居中
        springLayout.putConstraint(SpringLayout.NORTH, subTitle, 0, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, subTitle, -(Spring.width(subTitle).getValue() / 2), SpringLayout.HORIZONTAL_CENTER, loginPanel);


        loginPanel.add(subTitle);
//        loginPanel.add(accountLabel);
//        loginPanel.add(accountText);
//        loginPanel.add(passwordLabel);
//        loginPanel.add(passwordText);
//        loginPanel.add(loginButton);


        contentPane.add(title, BorderLayout.NORTH);
        contentPane.add(loginPanel, BorderLayout.CENTER);

        setIconImage(new ImageIcon(Objects.requireNonNull(LoginInter.class.getClassLoader().getResource("icon.png"))).getImage());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }


    public static void main(String[] args) {
        LoginInter loginInter = new LoginInter();
    }


}
